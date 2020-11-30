import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {

    @Test
    public void addingItemsIncreasesSize(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "", "");
        assertEquals(0, ctlist.getListSize());
        ctlist.addContact(itm);
        assertEquals(1,ctlist.getListSize());
    }
    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "", "");
        ctlist.addContact(itm);
        assertThrows(IllegalArgumentException.class, ()->{ctlist.editContact(0,"","","","");});
    }
    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "", "");
        ctlist.addContact(itm);
        assertThrows(IndexOutOfBoundsException.class, ()->{ctlist.editContact(2, "John", "doe", "", "");});
    }
    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "1234", "bananas");
        ctlist.addContact(itm);
        ctlist.editContact(0,"","baggins","4321","oranges");
        assertEquals(" baggins\nPhone Number: 4321\nEmail Address: oranges\n", ctlist.CntctList.get(0).toString());
    }
    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "1234", "bananas");
        ctlist.addContact(itm);
        ctlist.editContact(0,"bilbo","","4321","oranges");
        assertEquals("bilbo \nPhone Number: 4321\nEmail Address: oranges\n", ctlist.CntctList.get(0).toString());
    }
    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "1234", "bananas");
        ctlist.addContact(itm);
        ctlist.editContact(0,"bilbo","baggins","","oranges");
        assertEquals("bilbo baggins\nPhone Number: \nEmail Address: oranges\n", ctlist.CntctList.get(0).toString());
    }
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "1234", "bananas");
        ctlist.addContact(itm);
        ctlist.editContact(0,"bilbo","baggins","4321","oranges");
        assertEquals("bilbo baggins\nPhone Number: 4321\nEmail Address: oranges\n", ctlist.CntctList.get(0).toString());
    }
    @Test
    public void newListIsEmpty(){
        ContactList ctlist = new ContactList();
        assertEquals(true,ctlist.isListEmpty());
    }
    @Test
    public void removingItemsDecreasesSize(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "1234", "bananas");
        ContactItem itm2 = new ContactItem("bilbo","baggins", "4321", "oranges");
        ctlist.addContact(itm);
        ctlist.addContact(itm2);
        assertEquals(2,ctlist.getListSize());
        ctlist.removeContact(1);
        assertEquals(1,ctlist.getListSize());
    }
    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList ctlist = new ContactList();
        ContactItem itm = new ContactItem("john", "deer", "1234", "bananas");
        ContactItem itm2 = new ContactItem("bilbo","baggins", "4321", "oranges");
        ctlist.addContact(itm);
        ctlist.addContact(itm2);
        assertThrows(IndexOutOfBoundsException.class, ()-> {ctlist.removeContact(5);});
    }
    @Test
    public void savedContactListCanBeLoaded(){
        ContactList ctlist = new ContactList();
        ctlist.setFilename("test 1");
        assertDoesNotThrow(()->{ctlist.deSerializeFile();});
    }

}