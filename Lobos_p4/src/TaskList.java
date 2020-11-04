import java.util.ArrayList;

public class TaskList {
private String TaskListName;
private int TaskCount;
private ArrayList<TaskItem> TskList = new ArrayList<TaskItem>();

    TaskList(String TaskListName){
        this.TaskListName = TaskListName;
    }

    public int getListSize() {
        return this.TaskCount;
    }

    public void addItem(TaskItem tsk){
        TskList.add(tsk);
        this.TaskCount++;
    }

    public void editItemDesc(int TaskNum, String newDesc){
        try{
            if(TaskNum > this.TaskCount || TaskNum < 0){
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setDescription(newDesc);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }

    }

    public void markComplete(int TaskNum){
        try{
            if(TaskNum > this.TaskCount) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setCompleted(true);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }
    }


    // This object will contain the list of task list items
    // this will most likely be where we interface with the file directory,
    // however it could be here or in the app class
    // This list will have a title, and an element to contain the number of
    // task list items in the list.

    // REQUIREMENTS

    // - A TASK LIST SHALL CONTAIN 0 OR MORE ITEMS

}
