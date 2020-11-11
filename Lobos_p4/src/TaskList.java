import java.util.ArrayList;

public class TaskList {
private String TaskListName;
private int TaskCount;
private ArrayList<TaskItem> TskList = new ArrayList<TaskItem>();

    TaskList(String TaskListName){
        this.TaskListName = TaskListName;
        this.TaskCount = 0;
    }

    public void addItem(TaskItem tsk){
        this.TskList.add(tsk);
        this.TaskCount++;
    }

    public void removeItem(int TaskNum){
        try {
            if (TaskNum > this.TaskCount || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.remove(TaskNum);
            this.TaskCount--;
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a number between 0 and " + this.TaskCount);
        }
    }

    public boolean isListEmpty(){
        if (this.TaskCount == 0){
            return true;
        }else
            return false;
    }

    public int getListSize() {
        return this.TaskCount;
    }

    public String getItemDescription(int TaskNum){
        try {
            if (TaskNum > this.TaskCount || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getDescription();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }
    }

    public String getItemDueDate(int TaskNum){
        try {
            if (TaskNum > this.TaskCount || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getDueDate();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }
    }

    public String getItemTitle(int TaskNum){
        try {
            if (TaskNum > this.TaskCount || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getTitle();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }
    }

    public boolean getItemStatus(int TaskNum){
        try {
            if (TaskNum > this.TaskCount || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getCompletionStatus();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }
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

    public void editItemDueDate(int TaskNum, String newDate){
        try {
            if (TaskNum > this.TaskCount || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setDueDate(newDate);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }
    }

    public void editItemTitle(int TaskNum, String newTitle){
        try {
            if (TaskNum > this.TaskCount || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setTitle(newTitle);
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

    public void markIncomplete(int TaskNum){
        try{
            if(TaskNum > this.TaskCount) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setCompleted(false);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TaskCount);
        }
    }

    public void ListToString(){
        System.out.println(this.TaskListName);
        for(int i = 0; i < this.TaskCount; i++){
            System.out.printf(i + " : " + this.TskList.get(i).toString() + "%n");
        }
        return;
    }


    // This object will contain the list of task list items
    // this will most likely be where we interface with the file directory,
    // however it could be here or in the app class
    // This list will have a title, and an element to contain the number of
    // task list items in the list.

    // REQUIREMENTS

    // - A TASK LIST SHALL CONTAIN 0 OR MORE ITEMS

}
