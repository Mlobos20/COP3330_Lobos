import java.io.*;
import java.util.ArrayList;

public class TaskList implements Serializable {
private String TaskListName;
private String fileName;
ArrayList<TaskItem> TskList;

    public TaskList(){
        TskList = new ArrayList<TaskItem>();
    }

    public void setTitles(String name){
        this.TaskListName = name;
        this.fileName = (name + ".txt");
    }

    public void addItem(TaskItem tsk){
        this.TskList.add(tsk);
    }

    public void removeItem(int TaskNum){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.remove(TaskNum);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a number between 0 and " + this.TskList.size());
        }
    }

    public boolean isListEmpty(){
        if (this.TskList.size() == 0){
            return true;
        }else
            return false;
    }

    public int getListSize() {
        return this.TskList.size();
    }

    public String getItemDescription(int TaskNum){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getDescription();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public String getItemDueDate(int TaskNum){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getDueDate();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public String getItemTitle(int TaskNum){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getTitle();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public boolean getItemStatus(int TaskNum){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return this.TskList.get(TaskNum).getCompletionStatus();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public void editItemDesc(int TaskNum, String newDesc){
        try{
            if(TaskNum > this.TskList.size() || TaskNum < 0){
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setDescription(newDesc);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }

    }

    public void editItemDueDate(int TaskNum, String newDate){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setDueDate(newDate);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public void editItemTitle(int TaskNum, String newTitle){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setTitle(newTitle);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public void markComplete(int TaskNum){
        try{
            if(TaskNum > this.TskList.size()) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setCompleted(true);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public void markIncomplete(int TaskNum){
        try{
            if(TaskNum > this.TskList.size()) {
                throw new IndexOutOfBoundsException();
            }
            this.TskList.get(TaskNum).setCompleted(false);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task number between 0 and " + this.TskList.size());
        }
    }

    public boolean verifyIndex(int TaskNum){
        try {
            if (TaskNum > this.TskList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return true;
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task between 0 and " + this.TskList.size());
        }
    }

    public void setTskList(ArrayList<TaskItem> newList){
        for (TaskItem itm : newList){
            // System.out.println("Adding an item to the list");
            this.TskList.add(itm);
        }
    }

    public void serializeToFile(){
        try{
            FileOutputStream outToFile = new FileOutputStream(this.fileName);
            ObjectOutputStream output = new ObjectOutputStream(outToFile);
            output.writeObject(TskList);
            output.flush();
            output.close();
            outToFile.close();
            System.out.println("Serialization was successful... please verify in directory");
        } catch (FileNotFoundException e) {
            System.out.println("Error locating or creating file");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }

    public void deSerializeFile() throws FileNotFoundException {
        try{
            FileInputStream inFromFile = new FileInputStream(this.fileName);
            ObjectInputStream input = new ObjectInputStream(inFromFile);
            // System.out.println("Deserialized data? temporary print: \n" + input.readObject().toString());
            ArrayList<TaskItem> deSerializedList = (ArrayList<TaskItem>) input.readObject();
            setTskList(deSerializedList);
            System.out.println("Load Successful... operations now available to perform on loaded list");
            // ListToString();
            input.close();
            inFromFile.close();
        } catch (FileNotFoundException e) {
            // System.out.println("The file could not be found with the given file name...");
            throw new FileNotFoundException();
        } catch (IOException e){
            //System.out.println("IO exception");
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ListToString(){
        System.out.println(this.TaskListName);
        for(int i = 0; i < this.TskList.size(); i++){
            System.out.printf("Task #:" + i + " : " + this.TskList.get(i).toString() + "%n");
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
