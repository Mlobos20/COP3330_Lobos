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



}