import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

class TaskPanel extends JPanel {

    JLabel taskIndexLabel;
    JTextField taskNameField;
    JButton markDoneButton;

    Color lightPink = new Color(161, 161, 161);
    Color lightGreen = new Color(130, 226, 178);
    Color doneButtonColor = new Color(233, 119, 119);

    private boolean isTaskDone;

    TaskPanel() {
        this.setPreferredSize(new Dimension(400, 20)); // Set task panel size
        this.setBackground(lightPink); // Set task panel background color

        this.setLayout(new BorderLayout()); // Use BorderLayout for task panel

        isTaskDone = false;

        taskIndexLabel = new JLabel(""); // Initialize task index label
        taskIndexLabel.setPreferredSize(new Dimension(20, 20)); // Set label size
        taskIndexLabel.setHorizontalAlignment(JLabel.CENTER); // Center align label text
        this.add(taskIndexLabel, BorderLayout.WEST); // Add label to the left of panel

        taskNameField = new JTextField("Enter task here..."); // Initialize task name text field
        taskNameField.setBorder(BorderFactory.createEmptyBorder()); // Remove text field border
        taskNameField.setBackground(lightPink); // Set text field background color
        this.add(taskNameField, BorderLayout.CENTER); // Add text field to center of panel

        markDoneButton = new JButton("Done"); // Initialize done button
        markDoneButton.setPreferredSize(new Dimension(80, 20)); // Set button size
        markDoneButton.setBorder(BorderFactory.createEmptyBorder()); // Remove button border
        markDoneButton.setBackground(doneButtonColor); // Set button background color
        markDoneButton.setFocusPainted(false); // Remove focus paint
        this.add(markDoneButton, BorderLayout.EAST); // Add button to the right of panel

        markDoneButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                toggleTaskState();
            }
        });
    }

    public void updateIndex(int index) {
        this.taskIndexLabel.setText(String.valueOf(index)); // Update label text with index
        this.revalidate(); // Refresh panel
    }

    public JButton getMarkDoneButton() {
        return markDoneButton;
    }

    public boolean isTaskDone() {
        return isTaskDone;
    }

    public void markTaskDone() {
        if (!isTaskDone) {
            this.setBackground(lightGreen);
            taskNameField.setBackground(lightGreen);
            markDoneButton.setText("Not Done");
            isTaskDone = true;
        }
        revalidate();
    }

    public void markTaskNotDone() {
        if (isTaskDone) {
            this.setBackground(lightPink);
            taskNameField.setBackground(lightPink);
            markDoneButton.setText("Done");
            isTaskDone = false;
        }
        revalidate();
    }

    private void toggleTaskState() {
        if (isTaskDone) {
            markTaskNotDone();
        } else {
            markTaskDone();
        }
    }
}

class TaskListPanel extends JPanel {

    Color lightBeige = new Color(100, 100, 116);

    TaskListPanel() {
        GridLayout layout = new GridLayout(10, 1); // Initialize layout with 10 rows, 1 column
        layout.setVgap(5); // Set vertical gap between rows

        this.setLayout(layout); // Apply layout to panel
        this.setPreferredSize(new Dimension(400, 560)); // Set panel size
        this.setBackground(lightBeige); // Set panel background color
    }

    public void refreshTaskIndices() {
        Component[] taskComponents = this.getComponents();

        for (int i = 0; i < taskComponents.length; i++) {
            if (taskComponents[i] instanceof TaskPanel) {
                ((TaskPanel) taskComponents[i]).updateIndex(i + 1);
            }
        }
    }

    public void removeCompletedTasks() {
        for (Component component : getComponents()) {
            if (component instanceof TaskPanel) {
                if (((TaskPanel) component).isTaskDone()) {
                    remove(component); // Remove task from panel
                    refreshTaskIndices(); // Refresh task indices
                }
            }
        }
    }
}

class FooterPanel extends JPanel {

    JButton addTaskButton;
    JButton clearTasksButton;

    Color softOrange = new Color(233, 133, 128);
    Color lightBeige = new Color(252, 221, 176);
    Border noBorder = BorderFactory.createEmptyBorder();

    FooterPanel() {
        this.setPreferredSize(new Dimension(400, 60)); // Set footer panel size
        this.setBackground(lightBeige); // Set footer panel background color

        addTaskButton = new JButton("Add Task"); // Initialize add task button
        addTaskButton.setBorder(noBorder); // Remove button border
        addTaskButton.setFont(new Font("Sans-serif", Font.ITALIC, 20)); // Set button font
        addTaskButton.setVerticalAlignment(JButton.BOTTOM); // Align button text to bottom
        addTaskButton.setBackground(softOrange); // Set button background color
        this.add(addTaskButton); // Add button to footer panel

        this.add(Box.createHorizontalStrut(20)); // Add horizontal spacing

        clearTasksButton = new JButton("Clear Finished Tasks"); // Initialize clear tasks button
        clearTasksButton.setFont(new Font("Sans-serif", Font.ITALIC, 20)); // Set button font
        clearTasksButton.setBorder(noBorder); // Remove button border
        clearTasksButton.setBackground(softOrange); // Set button background color
        this.add(clearTasksButton); // Add button to footer panel
    }

    public JButton getAddTaskButton() {
        return addTaskButton;
    }

    public JButton getClearTasksButton() {
        return clearTasksButton;
    }
}

class TitlePanel extends JPanel {

    Color lightBeige = new Color(252, 221, 176);

    TitlePanel() {
        this.setPreferredSize(new Dimension(400, 80)); // Set title panel size
        this.setBackground(lightBeige); // Set title panel background color
        JLabel titleLabel = new JLabel("To-Do List"); // Initialize title label
        titleLabel.setPreferredSize(new Dimension(200, 60)); // Set label size
        titleLabel.setFont(new Font("Sans-serif", Font.BOLD, 20)); // Set label font
        titleLabel.setHorizontalAlignment(JLabel.CENTER); // Center align label text
        this.add(titleLabel); // Add label to title panel
    }
}

class ToDoAppFrame extends JFrame {

    private TitlePanel titlePanel;
    private FooterPanel footerPanel;
    private TaskListPanel taskListPanel;

    private JButton addTaskButton;
    private JButton clearTasksButton;

    ToDoAppFrame() {
        this.setSize(400, 600); // Set frame size
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set close operation
        this.setVisible(true); // Make frame visible

        titlePanel = new TitlePanel();
        footerPanel = new FooterPanel();
        taskListPanel = new TaskListPanel();

        this.add(titlePanel, BorderLayout.NORTH); // Add title panel to frame
        this.add(footerPanel, BorderLayout.SOUTH); // Add footer panel to frame
        this.add(taskListPanel, BorderLayout.CENTER); // Add task list panel to frame

        addTaskButton = footerPanel.getAddTaskButton();
        clearTasksButton = footerPanel.getClearTasksButton();

        initializeListeners();
    }

    private void initializeListeners() {
        addTaskButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TaskPanel taskPanel = new TaskPanel();
                taskListPanel.add(taskPanel); // Add new task to list panel
                taskListPanel.refreshTaskIndices(); // Refresh task indices
                revalidate(); // Refresh frame
            }
        });

        clearTasksButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                taskListPanel.removeCompletedTasks(); // Remove completed tasks
                repaint(); // Repaint frame
            }
        });
    }
}

public class ToDoListApp {

    public static void main(String[] args) {
        new ToDoAppFrame(); // Create and display the frame
    }
}

@interface Override {}
