package com.radu;

import com.radu.contacts.Database;
import com.radu.utilities.Print;

public class Main {

    //TODO: The program will have a contacts with:
    //1. id
    //2. full name
    //3. phone number
    //4. email address
    //5. address
    //Contacts' name will be added using a Faker, as well as their phone numbers and their addresses.
    //Their emails will be returned by a method which concatenates contacts' names: fullnames@gmail.com


    public static void main(String[] args) {
        App app = new App();

        Print.printWelcome();
        app.runApp(Database.getContacts());
    }
}
