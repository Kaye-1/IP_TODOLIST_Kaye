package IP;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// The class Task will implement the interface Serializable. The Serializable interface will help the JVM to
// convert states of an object into a permanent state in disk or memory in the computer.
public class Task implements Serializable {
    private String title;
    private String project;
    private boolean complete;
    private LocalDate dueDate;

    // Creating an object of Task class
    public Task(String title, String project, LocalDate dueDate) {

        this.setTitle(title);
        this.setProject(project);
        this.complete = false;
        this.setDueDate(dueDate);
    }

    // A method to get the task title
    public String getTitle() {
        return this.title;
    }

    // A method to set the title of a Task object, it mandatory to enter title.
    // The trim() is used to eliminate the spaces before and after the title. The the title.trim() will return the title
    // it self. the method accepts no parameters.
    public void setTitle(String title) throws NullPointerException {
        if (title.trim().equals("") || title == null) {
            throw new NullPointerException("REQUIRED: Title can not be empty.");
        }
        this.title = title.trim();
    }

    // A method to get the project name, Project name can be empty.
    public String getProject() {
        return this.project;
    }

    // A method to set the project name
    public void setProject(String project) {
        this.project = project.trim();
    }

    // A method to get the completed status of task
    public boolean isComplete() {
        return this.complete;
    }

    // A method to mark a task as  it is incomplete
    public boolean markInComplete() {
        this.complete = false;
        return this.complete;
    }

    // A method to mark a task as completed
    public boolean markCompleted() {
        this.complete = true;
        return this.complete;
    }

    // A method to get the due date of the task
    public LocalDate getDueDate() {
        return dueDate;
    }

    // A method to set the due date of a task as yyyy-mm-dd format, it is mandatory to enter the due date.
    public void setDueDate(LocalDate dueDate) throws DateTimeException {
        // Throw DateTimeException if past date is given
        if (dueDate.compareTo(LocalDate.now())<0) {
            throw new DateTimeException("Past Date not allowed");
        }

        //Ensure dueDate is saved as yyyy-MM-dd
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dueDate = LocalDate.parse(dueDate.format(formattedDate));
    }

    // A method to get the task data as formatted string to display in multiple lines
    public String formattedStringOfTask() {
        return (
                "\nTitle     : " + title +
                        "\nProject   : " + project +
                        "\nStatus    : " + (complete?"Completed":"NOT COMPLETED") +
                        "\nDue Date  : " + dueDate +
                        "\n");
    }
}



