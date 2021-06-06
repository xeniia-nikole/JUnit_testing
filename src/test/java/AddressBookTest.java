import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AddressBookTest {
    AddressBook addressBook;

    @BeforeAll
    void create_values (){addressBook = new AddressBook();}


    @Test
    void test_addContact() {
        //given
        Contact contact = new Contact("Anna", "89099854321", Group.WORK);


        Assertions.assertTrue(addressBook.addContact(contact));

    }

    @Test
    void test_findContact() {
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

        // expected
        String expected = ">>Контакт с таким номером телефона не существует";

        // when
        addressBook.deleteContact(contactName);
        String actual = findContactByNumber("89571233445");

        // then
        Assertions.assertEquals(expected, actual);
    }

}
