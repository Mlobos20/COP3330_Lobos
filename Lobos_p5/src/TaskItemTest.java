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

    @Test
    public void constructorFailsWithInvalidDueDate(){
        assertThrows(IllegalArgumentException.class, ()->{TaskItem tsk = new TaskItem("og title", "", "11-30-2020");});
    }
    @Test
    public void constructorFailsWithInvalidTitle(){
        assertThrows(IllegalArgumentException.class, ()->{TaskItem tsk = new TaskItem("", "description", "2020-11-30");});
    }
    @Test
    public void constructorSucceedsWithValidDueDate(){
        TaskItem itm  = new TaskItem("title", "description", "2020-11-30");
        assertEquals("2020-11-30", itm.getDueDate());
    }
    @Test
    public void constructorSucceedsWithValidTitle(){
        TaskItem itm  = new TaskItem("title", "description", "2020-11-30");
        assertEquals("title", itm.getTitle());
    }
    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        TaskItem itm  = new TaskItem("title", "description", "2020-11-30");
        itm.setDescription("new description");
        assertEquals("new description", itm.getDescription());
    }
    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){
        TaskItem itm  = new TaskItem("title", "description", "2020-11-30");
        assertThrows(IllegalArgumentException.class, ()->{itm.setDueDate("30-2020-11");});
    }
    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD(){
        TaskItem itm = new TaskItem("title", "description", "2020-11-30");
        assertThrows(IllegalArgumentException.class, ()->{itm.setDueDate("2020-15-30");});
    }
    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        TaskItem itm = new TaskItem("title", "description", "2020-11-30");
        itm.setDueDate("2020-12-01");
        assertEquals("2020-12-01", itm.getDueDate());
    }
    @Test
    public void editingTitleFailsWithEmptyString(){
        TaskItem itm = new TaskItem("title", "description", "2020-11-30");
        assertThrows(IllegalArgumentException.class, ()->{itm.setTitle("");});
    }
    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        TaskItem itm = new TaskItem("title", "description", "2020-11-30");
        itm.setTitle("new title");
        assertEquals("new title", itm.getTitle());
    }

}