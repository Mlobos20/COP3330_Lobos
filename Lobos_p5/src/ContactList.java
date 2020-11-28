import java.io.*;
import java.util.ArrayList;

public class ContactList implements Serializable{
private String filename;
ArrayList<ContactItem> CntctList;

    // constructor for the contact list.
    public ContactList(){
        CntctList = new ArrayList<ContactItem>();
    }

    public void setFilename(String name){
        this.filename = (name + ".txt");
    }

    public void addContact(ContactItem cntct){
        this.CntctList.add(cntct);
    }

    public void removeContact(int indexNum){
        try{
            if(indexNum > this.CntctList.size() || indexNum < 0){
                throw new IndexOutOfBoundsException();
            }
            this.CntctList.remove(indexNum);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a number between 0 and " + this.CntctList.size());
        }
    }

    public void editContactFirstName(int Tasknum, String fName){
        try{
            if(Tasknum < 0 || Tasknum > this.CntctList.size()){
                throw new IndexOutOfBoundsException();
            }
            this.CntctList.get(Tasknum).setFirstName(fName);
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public void editContactLastName(int Tasknum, String lName){
        try{
            if(Tasknum < 0 || Tasknum > this.CntctList.size()){
                throw new IndexOutOfBoundsException();
            }
            this.CntctList.get(Tasknum).setLastName(lName);
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public void editContactPhoneNumber(int Tasknum, String pNum){
        try{
            if(Tasknum < 0 || Tasknum > this.CntctList.size()){
                throw new IndexOutOfBoundsException();
            }
            this.CntctList.get(Tasknum).setPhoneNumber(pNum);
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public void editContactEmailAddress(int Tasknum, String eAdd){
        try{
            if(Tasknum < 0 || Tasknum > this.CntctList.size()){
                throw new IndexOutOfBoundsException();
            }
            this.CntctList.get(Tasknum).setEmailAddress(eAdd);
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isListEmpty(){
        if (this.CntctList.size() == 0){
            return true;
        }else
            return false;
    }

    public boolean verifyIndex(int TaskNum){
        try {
            if (TaskNum > this.CntctList.size() || TaskNum < 0) {
                throw new IndexOutOfBoundsException();
            }
            return true;
        } catch (IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Please enter a task between 0 and " + this.CntctList.size());
        }
    }

    public int getListSize(){
        return this.CntctList.size();
    }

    public boolean isValidContact(int TaskNum){
        CntctList.get(TaskNum).checkEmpty();
        return CntctList.get(TaskNum).returnEmptyStatus();
    }

    private void setTskList(ArrayList<ContactItem> newList){
        for (ContactItem itm : newList){
            // System.out.println("Adding an item to the list");
            this.CntctList.add(itm);
        }
    }

    public void serializeToFile(){
        try{
            FileOutputStream outToFile = new FileOutputStream(this.filename);
            ObjectOutputStream output = new ObjectOutputStream(outToFile);
            output.writeObject(CntctList);
            output.flush();
            output.close();
            outToFile.close();
            System.out.println("Serialization was successful... please verify in directory");
        } catch (FileNotFoundException e) {
            System.out.println("Error locating or creating file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deSerializeFile() throws FileNotFoundException {
        try{
            FileInputStream inFromFile = new FileInputStream(this.filename);
            ObjectInputStream input = new ObjectInputStream(inFromFile);
            // System.out.println("Deserialized data? temporary print: \n" + input.readObject().toString());
            ArrayList<ContactItem> deSerializedList = (ArrayList<ContactItem>) input.readObject();
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
        for (int i = 0; i < this.CntctList.size(); i++){
            System.out.printf("Contact #%d%n", i);
            System.out.println(this.CntctList.get(i).toString());
        }
        return;
    }

}
