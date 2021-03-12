package IP;
import java.util.Scanner;

public class Main {
    // A string to hold the data file name which contains all tasks and their details
    public static String filename = "tasks.obj";

    // Main method to run the command line based "To Do List" application
    public static void main(String args[]) {
        // An object of TodoList to hold all tasks and their data
        ToDoList todoList = new ToDoList();

        //A string to hold the choice that will be entered by the user
        String menuChoice = "1";

        try {
            Scanner input = new Scanner(System.in);

            // reading the date from task data file
            // if this is the first time, a message will be shown that no data file is found
            todoList.read(filename);

            Messages.showMessage("Welcome to ToDoList", false);

            while (!menuChoice.equals("4")) {
                Messages.mainMenu(todoList.numberOfUncompletedTasks(), todoList.numberOfCompletedTasks());
                menuChoice = input.nextLine();

                switch (menuChoice) {
                    case "1":
                        Messages.listAllTasksMenu();
                        todoList.listAllTasks(input.nextLine());
                        break;
                    case "2":
                        todoList.readTaskFromUser();
                        break;
                    case "3":
                        todoList.listAllTasksWithIndex();
                        Messages.editTaskSelection();
                        todoList.editTask(input.nextLine());
                        break;
                    case "4":
                        break;

                    default:
                        Messages.unknownMessage();
                }
            }

            // saving the task details in data file
            // if this is the first time, a new task file will be created
            todoList.save(filename);
            Messages.byeMessage();

        } catch (Exception e) {
            Messages.showMessage("UNCAUGHT EXCEPTION THROWN", true);
            System.out.println("Trying to write the unsaved data of all tasks in data file");
            todoList.save(filename);
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
}

