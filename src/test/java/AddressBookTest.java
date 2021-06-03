import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AddressBookTest {


    @Test
    void operation_addContact_is_ok() {
        AddressBook myContacts = new AddressBook();
        Contact contact = new Contact("Anna", "89099854321", Group.WORK);

        Assertions.assertTrue(myContacts.addContact(contact));

    }

    @Test
    void operation_findContact_is_ok() {
        AddressBook myContacts = new AddressBook();
        myContacts.addContact(new Contact("John", "89012345678", Group.WORK));
        String contactNumber = "89012345678";

        String expected = "Группа: WORK, имя контакта: John, номер контакта: 89012345678";

        String actual = myContacts.findContactByNumber(contactNumber);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void operation_deleteContact_is_ok() {
        AddressBook myContacts = new AddressBook();
        myContacts.addContact(new Contact("Melinda", "89571233445", Group.OTHERS));
        String contactName = "Melinda";

        Contact contact = myContacts.getContacts().get("89571233445");

        boolean expected = !(myContacts.getContacts().containsValue(contact));

        boolean actual = myContacts.deleteContact(contactName);

        Assertions.assertEquals(expected, actual);
    }

}
