import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;


class TaskItemTest {

    // automated unit tests to test every aspect of the app

    // Examples of the tests needed to include:

    // Task Item Tests

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(IllegalArgumentException.class, () -> {TaskItem tsk = new TaskItem("a", "", "11-2020-03");} );
    }
    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class, () -> {TaskItem tsk = new TaskItem("", "", "2020-11-03");} );
    }
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem tsk = new TaskItem("a", "", "2020-11-03");
        LocalDate Date;
        Date = LocalDate.parse("2020-11-03");
        assertEquals(Date.toString(), tsk.getDueDate());
    }
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem tsk = new TaskItem("a", "", "2020-11-03");
        assertEquals("a", tsk.getTitle());
    }
    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem tsk = new TaskItem("a", "", "2020-11-03");
        assertThrows(IllegalArgumentException.class, () -> { tsk.setDueDate("11-2020-03"); });
    }
    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem tsk = new TaskItem("a", "", "2020-11-03");
        tsk.setDueDate("2020-11-04");
        assertEquals("2020-11-04", tsk.getDueDate());
    }
    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem tsk = new TaskItem("title", "", "2020-11-03");
        assertThrows(IllegalArgumentException.class, () -> {
            tsk.setTitle("");
        });
    }
    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem tsk = new TaskItem("Original Title", "", "2020-11-03");
        tsk.setTitle("New Title");
        assertEquals("New Title", tsk.getTitle());
    }


    // Task List Tests
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("task 1", "", "2020-11-04");
        tskList.addItem(tsk);
        assertEquals(1,tskList.getListSize());
    }
    @Test
    public void completingTaskItemChangesStatus(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("task 1", "", "2020-11-04");
        tskList.addItem(tsk);
        tskList.markComplete(0);
        assertEquals(true, tsk.getCompletionStatus());
    }
    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("task 1", "", "2020-11-04");
        tskList.addItem(tsk);
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.markComplete(2);} );
    }
    @Test
    public void editingTaskItemChangesValues(){
        TaskItem tsk = new TaskItem("Original Title", "This is a description", "2020-11-04");
        tsk.setTitle("This is a renewed Title");
        tsk.setDescription("This is a new description");
        tsk.setDueDate("2020-11-09");
        tsk.setCompleted(true);
        assertEquals("***This is a renewed Title: This is a new description. Due: 2020-11-09", tsk.toString());
    }
    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("Title", "Original Description", "2020-11-04");
        tskList.addItem(tsk);
        tskList.editItemDesc(0, "This is an edited description");
        assertEquals("This is an edited description", tsk.getDescription());
    }
    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "", "2020-11-04");
        tskList.addItem(tsk);
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.editItemDesc(2,"New Description");} );
    }
    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "", "2020-11-03");
        tskList.addItem(tsk);
        tskList.editItemDueDate(0,"2020-11-04");
        assertEquals("2020-11-04", tsk.getDueDate());
    }
    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "", "2020-11-03");
        tskList.addItem(tsk);
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.editItemDueDate(1,"2020-11-04");});
    }
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "", "2020-11-03");
        tskList.addItem(tsk);
        tskList.editItemTitle(0, "This is the new Title of the task");
        assertEquals("This is the new Title of the task", tsk.getTitle());
    }
    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "", "2020-11-03");
        tskList.addItem(tsk);
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.editItemTitle(2, "This is a new title");} );
    }
    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "This is the description", "2020-11-03");
        tskList.addItem(tsk); // It fails since there is only 1 item and I ask for index 2
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.getItemDescription(2);} );
    }
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "This is the description", "2020-11-04");
        tskList.addItem(tsk);
        assertEquals("This is the description", tskList.getItemDescription(0));
    }
    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "", "2020-11-04");
        tskList.addItem(tsk); // Fails since there is only 1 item and I ask for index 2
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.getItemDueDate(2);} );
    }
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("A", "", "2020-11-04");
        tskList.addItem(tsk);
        assertEquals("2020-11-04", tskList.getItemDueDate(0));
    }
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("This is a title", "", "2020-11-04");
        tskList.addItem(tsk);
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.getItemTitle(2);} );
    }
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("This is a title", "", "2020-11-04");
        tskList.addItem(tsk);
        assertEquals("This is a title", tskList.getItemTitle(0));
    }
    @Test
    public void newTaskListIsEmpty(){
        TaskList tskList = new TaskList();
        assertEquals(true, tskList.isListEmpty());
    }
    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList tskList = new TaskList();
        TaskItem tsk1 = new TaskItem("a", "", "2020-11-04");
        TaskItem tsk2 = new TaskItem("b", "", "2020-11-05");
        TaskItem tsk3 = new TaskItem("3", "", "2020-12-25");
        tskList.addItem(tsk1);
        tskList.addItem(tsk2);
        tskList.addItem(tsk3);
        tskList.removeItem(2);
        assertEquals(2, tskList.getListSize());
    }
    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk1 = new TaskItem("a", "", "2020-11-04");
        TaskItem tsk2 = new TaskItem("b", "", "2020-11-05");
        TaskItem tsk3 = new TaskItem("3", "", "2020-12-25");
        tskList.addItem(tsk1);
        tskList.addItem(tsk2);
        tskList.addItem(tsk3);
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.removeItem(5);} );
    }
    @Test
    public void savedTaskListCanBeLoaded(){

        //assertTrue();
    }
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("a", "", "2020-11-04");
        tskList.addItem(tsk);
        tskList.markIncomplete(0);
        assertEquals(false, tskList.getItemStatus(0));
    }
    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList tskList = new TaskList();
        TaskItem tsk = new TaskItem("a", "", "2020-11-04");
        tskList.addItem(tsk);
        assertThrows(IndexOutOfBoundsException.class, () -> {tskList.getItemStatus(2);} );
    }
}