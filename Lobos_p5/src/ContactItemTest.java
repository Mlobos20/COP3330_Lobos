import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest {
    @Test
    public void creationFailsWithAllBlankValues(){
        assertThrows(IllegalArgumentException.class, () -> {ContactItem itm = new ContactItem("","","","");} );
    }
    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactItem itm = new ContactItem("1","1","1","");
        assertEquals("1", itm.getFirstName());
    }
    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactItem itm = new ContactItem("","1","1","1");
        assertEquals("1", itm.getLastName());
    }
    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactItem itm = new ContactItem("1","","1","1");
        assertEquals("1", itm.getFirstName());
    }
    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactItem itm = new ContactItem("1","1","","1");
        assertEquals("1", itm.getFirstName());
    }
    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactItem itm = new ContactItem("1", "1", "1", "1");
        assertEquals("1", itm.getFirstName());
        assertEquals("1", itm.getLastName());
        assertEquals("1", itm.getPhoneNumber());
        assertEquals("1", itm.getEmailAddress());
    }
    @Test
    public void editingFailsWithAllBlankValues(){
        ContactItem itm = new ContactItem("1", "1", "1", "1");
        assertThrows(IllegalArgumentException.class, ()->{itm.editContact("","","","");} );
    }
    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactItem itm = new ContactItem("1", "1", "1", "1");
        itm.editContact("1","1","1","");
        assertEquals("", itm.getEmailAddress());
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactItem itm = new ContactItem("1", "1", "1", "1");
        itm.editContact("","1","1","1");
        assertEquals("", itm.getFirstName());
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactItem itm = new ContactItem("1", "1", "1", "1");
        itm.editContact("1","","1","1");
        assertEquals("", itm.getLastName());
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactItem itm = new ContactItem("1", "1", "1", "1");
        itm.editContact("1","1","","1");
        assertEquals("", itm.getPhoneNumber());
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactItem itm = new ContactItem("1", "1", "1", "1");
        itm.editContact("2","2","2","2");
        assertEquals("2", itm.getFirstName());
        assertEquals("2", itm.getLastName());
        assertEquals("2", itm.getPhoneNumber());
        assertEquals("2", itm.getEmailAddress());
    }
    @Test
    public void testToString(){
        ContactItem itm = new ContactItem("John","Doe", "407-555-5555", "johnnyD@forest.com");
        assertEquals("John Doe\nPhone Number: 407-555-5555\nEmail Address: johnnyD@forest.com\n", itm.toString());
    }

}