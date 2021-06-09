import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

class AddressBookTest {
    public static AddressBook addressBook;

    @BeforeAll
    static void create_values (){addressBook = new AddressBook();}


    @Test
    void test_addContact() {
        //given
        Contact contact = new Contact("Anna", "89099854321", Group.WORK);


        Assertions.assertTrue(addressBook.addContact(contact));

    }

    @Test
    void test_findContactByNumber() {
        // given
        addressBook.addContact(new Contact("John", "89012345678", Group.WORK));
        String contactNumber = "89012345678";

        // expected
        String expected = "Группа: WORK, имя контакта: John, номер контакта: 89012345678";

        // when
        String actual = addressBook.findContactByNumber(contactNumber);

        // then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void test_deleteContact() {
        // given
        addressBook.addContact(new Contact("Melinda", "89571233445", Group.OTHERS));
        String contactName = "Melinda";
        String contactNumber = "89571233445";

        // expected
        String expected = null;

        // when
        addressBook.deleteContact(contactName);
        String actual = addressBook.findContactByNumber(contactNumber);

        // then
        Assertions.assertEquals(expected, actual);
    }

}
