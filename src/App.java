public class App {
    public static void main(String[] args) throws Exception {
        phonebook contacts = new phonebook();
        contacts.loadContacts();
        contacts.addContact();
        contacts.saveContacts();
        contacts.display();

    }
}
