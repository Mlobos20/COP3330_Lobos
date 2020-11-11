import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    private String Title;
    private String Description;
    private LocalDate DueDate;
    private boolean CompletionStatus;
    private String completionMarker = "***";

    // constructor for a task item
    TaskItem(String Title, String Description, String DueDate){
        // try to set the title, but it expects a string
        try{
            if(Title.length() < 1) {
                // If the title length is less than 1 we throw an exception.
                throw new IllegalArgumentException();
            }
            this.Title = Title;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Title must be 1 or more characters in length");
        }

        // No try/catch block here since there are no restrictions on the description
        this.Description = Description;

        // try to set the date, using a localdate object and its parser
        try{
            this.DueDate = LocalDate.parse(DueDate);
        }catch(DateTimeParseException e){
            throw new IllegalArgumentException("Please enter the date in the format YYYY-MM-DD");
//            System.out.println("Please enter the date in the format YYYY-MM-DD");
        }

        this.CompletionStatus = false;
    }

    // various get functions
    public String getDueDate(){
        return this.DueDate.toString();
    }

    public String getTitle(){
        return this.Title;
    }

    public String getDescription() {
        return this.Description;
    }

    public boolean getCompletionStatus(){
        return this.CompletionStatus;
    }

    // various set functions
    public void setTitle(String NewTitle){
        try{
            if(NewTitle.length() < 1) {
                // If the title length is less than 1 we throw an exception.
                throw new IllegalArgumentException();
            }
            this.Title = NewTitle;
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException("Title must be 1 or more characters in length");
        }
    }

    public void setDescription(String desc){
        this.Description = desc;
    }

    public void setDueDate(String NewDate){
        try{
            this.DueDate = LocalDate.parse(NewDate);
        }catch(DateTimeParseException e){
            throw new IllegalArgumentException("Please enter the date in the format YYYY-MM-DD");
        }
    }

    public void setCompleted(boolean status){
        this.CompletionStatus = status;
    }

    // This was created to be able to output the task item to a file in the correct format
    @Override
    public String toString(){
        if(!getCompletionStatus()) {
            return (this.Title + ":" + " " + this.Description + " " + " Due: " + this.DueDate);
        }
        else{
            return (this.completionMarker + this.Title + ":" + " " + this.Description + "." + " Due: " + this.DueDate);
        }
    }




    //This is the class will house all of the information pertinent to a task
    // this includes the tasks name, due date, and description
    // This also needs to contain a way to flag if an item is marked
    // as well as if an item has been completed.

    //REQUIREMENTS

    // - A TASK ITEM SHALL CONTAIN A TITLE
    //      - A title shall be 1 or more characters in length
    // - A TASK ITEM SHALL CONTAIN A DESCRIPTION
    //      - A description shall be 0 or more characters in length
    // - A TASK ITEM SHALL CONTAIN A DUE DATE
    //      - A due date shall be in the format YYYY-MM-DD

}
