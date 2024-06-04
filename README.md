# ToDo List Application

This is a simple ToDo List application built using Java Swing. It allows users to add tasks, mark them as done, and clear all completed tasks. The application is structured with a user-friendly interface and is ideal for managing daily tasks efficiently.

## Features

- **Add Task:** Add a new task to the list.
- **Mark Task as Done:** Mark tasks as completed.
- **Clear Finished Tasks:** Remove all completed tasks from the list.
- **Dynamic Indexing:** Automatically update task indices after adding or removing tasks.

## Application Structure

- **TaskPanel:** Represents an individual task with an index label, a task name field, and a button to mark the task as done.
- **TaskListPanel:** A container panel that holds all the TaskPanels and manages their layout and indices.
- **FooterPanel:** Contains buttons for adding new tasks and clearing completed tasks.
- **TitlePanel:** Displays the title of the application.
- **ToDoAppFrame:** The main application frame that integrates all the panels and handles user interactions.

## Screenshots

![ToDo List Application Screenshot](https://github.com/shovanpaul48/JavaToDoApp/blob/main/Screenshot%202024-06-04%20224127.png?raw=true)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.
- An Integrated Development Environment (IDE) like IntelliJ IDEA, Eclipse, or NetBeans.

### Installation

1. **Clone the repository:**

    ```sh
    https://github.com/shovanpaul48/JavaToDoApp.git
    cd todolistapp
    ```

2. **Open the project in your IDE.**

3. **Run the application:**
    - Locate the `ToDoListApp` class containing the `main` method.
    - Run this class to start the application.

## Usage

1. **Adding a Task:**
    - Click the "Add Task" button in the footer to create a new task.
    - Enter the task description in the text field provided.

2. **Marking a Task as Done:**
    - Click the "Done" button next to the task to mark it as completed.
    - The task will change color to indicate its completion status.

3. **Clearing Finished Tasks:**
    - Click the "Clear Finished Tasks" button in the footer to remove all completed tasks from the list.

## Code Overview

### TaskPanel.java

Handles the individual task components, including task state toggling between done and not done.

### TaskListPanel.java

Manages the list of tasks, including adding new tasks and removing completed tasks. It also handles the re-indexing of tasks.

### FooterPanel.java

Contains buttons for adding new tasks and clearing finished tasks.

### TitlePanel.java

Displays the title of the application.

### ToDoAppFrame.java

The main frame that sets up the panels and initializes user interaction listeners.

## Customization

You can customize the application by modifying the color scheme, fonts, and layout dimensions in the respective panel classes.

## Contributing

1. **Fork the repository.**
2. **Create a new branch:**

    ```sh
    git checkout -b feature-branch
    ```

3. **Make your changes and commit them:**

    ```sh
    git commit -m 'Add new feature'
    ```

4. **Push to the branch:**

    ```sh
    git push origin feature-branch
    ```

5. **Submit a pull request.**
