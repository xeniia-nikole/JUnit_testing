import java.util.*;

class Main {
    public static void main(String[] args) {
        AddressBook myContacts = new AddressBook();
        MissedCalls myMissedCalls = new MissedCalls();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Программа: пропущенные вызовы");

        while (true) {
            menu();
            int use = Integer.parseInt(scanner.nextLine());
            if (use == 7)
                break;
            switch (use) {
                case 1:
// добавить контакт
                    System.out.println("Введите имя нового контакта: ");
                    String contactName = scanner.nextLine();
                    System.out.println("Введите номер телефона: ");
                    String contactPhone = scanner.nextLine();
                    System.out.println("Выберите группу для добавления: работа, семья, друзья, другое");
                    String group = scanner.nextLine();
                    Group contactGroup;
                    switch (group) {
                        case "работа":
                            contactGroup = Group.WORK;
                            break;
                        case "семья":
                            contactGroup = Group.FAMILY;
                            break;
                        case "друзья":
                            contactGroup = Group.FRIENDS;
                            break;
                        case "другое":
                            contactGroup = Group.OTHERS;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + group);
                    }
                    Contact contact = new Contact(contactName, contactPhone, contactGroup);
                    if (myContacts.addContact(contact)) {
                        System.out.println(">>Контакт добавлен");
                    } else {
                        System.out.println(">>Такой контакт уже существует");
                    }
                    break;

                case 2:
// найти контакт по номеру
                    System.out.println("Введите номер телефона: ");
                    String findContact = scanner.nextLine();
                    System.out.println(myContacts.findContactByNumber(findContact));
                    break;

                case 3:
// удалить контакт по фамилии
                    System.out.println("Введите имя контакта: ");
                    String deleteContactName = scanner.nextLine();
                    if (myContacts.deleteContact(deleteContactName)) {
                        System.out.println(">>Контакт успешно удален");
                    } else {
                        System.out.println(">>Что-то пошло не так");
                    }
                    break;

                case 4:
// добавить пропущенный вызов
                    System.out.println("Введите номер телефона пропущенного вызова: ");
                    String missedCallNUmber = scanner.nextLine();
                    myMissedCalls.addMissedCall(missedCallNUmber);
                    break;

                case 5:
// вывести список пропущенных вызовов
                    myMissedCalls.missedCallsList(myContacts);
                    break;

                case 6:
// очистить пропущенные вызовы
                    if (myMissedCalls.clearmissedCallsList())
                    System.out.println(">>Список пропущенных вызовов очищен");
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + use);
            }
        }

        System.out.println("Всего доброго!");
    }

    public static void menu() {
        System.out.println();
        System.out.println();
        System.out.println("Меню:\n " + "1. Добавить контакт\n " + "2. Найти контакт по номеру\n "
                + "3. Удалить контакт по имени\n " + "4. Добавить пропущенный вызов\n " + "5. Вывести все пропущенные вызовы\n "
                + "6. Очистить пропущенные вызовы\n " + "7. Выход\n " + "Выберите пункт из меню (1-7):");
    }
}