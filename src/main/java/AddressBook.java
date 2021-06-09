import java.util.HashMap;
import java.util.Map;

class AddressBook {
    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    private Map<String, Contact> contacts = new HashMap<>();

    public Map<String, Contact> getContacts() {
        return contacts;
    }

    public boolean addContact(Contact contact) {
        boolean result = !contacts.containsKey(contact.getNumber());
        contacts.put(contact.getNumber(), contact);
        return result;
    }

    public String findContactByNumber(String findContact) {
        String contact = null;
        if (contacts.containsKey(findContact)) {
        contact = contacts.get(findContact).toString();
        } else {
            System.out.println(">>Контакт с таким номером телефона не существует");
        }
        return contact;
    }

    public boolean deleteContact(String deleteContact){
        boolean result = true;
        for (Map.Entry<String, Contact> it : contacts.entrySet()) {
            if (it.getValue().getName().equals(deleteContact))
                contacts.remove(it.getKey());
            if (it.getValue().getName().equals(deleteContact)) result = false;
        }
        return result;
    }

    public String checkContact (String missed){
        String thisContact = null;
        if (contacts.containsKey(missed)) {
            Contact thisPerson = contacts.get(missed);
            thisContact = thisPerson.getName();
        }
        return thisContact;
    }

}
