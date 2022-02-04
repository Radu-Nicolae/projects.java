package com.radu.utilities.options;

import com.radu.App;
import com.radu.contacts.Contact;
import com.radu.utilities.AppUtilities;

import java.util.List;

public class Option2 {

    public static void runOption2(List<Contact> contacts) {
        App app = new App();
        AppUtilities.printContact(contacts);

        app.runApp(contacts);
    }
}
