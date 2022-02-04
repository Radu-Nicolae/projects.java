package com.radu.utilities.options;

import com.radu.App;
import com.radu.contacts.Contact;
import com.radu.utilities.Print;

import java.util.List;
import java.util.Scanner;

public class Option5 {

    static App app = new App();
    static Scanner scn = new Scanner(System.in);
    static Contact contact;

    public static List<Contact> runOption5(List<Contact> contacts) {
        Print.printDatabase(contacts);

        System.out.print("\nEnter the index of the contact you want to remove: ");

        String indexString;

        int indexInt = 0;
        boolean haveCaught;
        do {
            indexString = scn.next();
            try {
                indexInt = Integer.parseInt(indexString);
                haveCaught = true;

                if (indexInt < 1 || indexInt > contacts.size()) {
                    haveCaught = false;
                    System.out.print("Please enter a valid number: ");
                }
            } catch (Exception ex) {
                System.out.print("Please enter a valid number: ");
                haveCaught = false;
            }
        }
        while (!haveCaught);

        contact = contacts.get(indexInt);

        System.out.println("\nYou are about to remove the following contact: ");
        Print.printContact(contact);

        System.out.print("\nConfirm? You answer (yes/no): ");

        boolean isInputInvalid = true;
        String input;

        Scanner sc = new Scanner(System.in); //declaring a new scanner because the static one
                    //skips some lines of code because of its bugs

        do {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                isInputInvalid = false;
            } else {
                System.out.print("Please choose yes or no: ");
            }
        }
        while (isInputInvalid);


        if (input.equalsIgnoreCase("yes")) {
            System.out.println("\nContact successfully removed!\n\n");
            contacts.remove(contact);
        } else {
            System.out.println("\nThe contact wasn't removed!\n\n");
        }

        app.runApp(contacts);

        return contacts;
    }
}
