package com.radu.utilities.options;

import com.radu.App;
import com.radu.contacts.Contact;
import com.radu.utilities.Print;

import java.util.List;

public class Option1 {

    public static void runOption1(List<Contact> contacts) {
        App app = new App();

        Print.printDatabase(contacts);
        System.out.println("\n");

        app.runApp(contacts);
    }
}
