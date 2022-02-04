package com.radu.utilities.options;

import com.radu.App;
import com.radu.contacts.Contact;
import com.radu.utilities.AppUtilities;
import com.radu.utilities.Print;

import java.util.List;
import java.util.Scanner;

public class Option3 {

    static Scanner scn = new Scanner(System.in);
    static App app = new App();

    public static List<Contact> runOption3(List<Contact> contacts) {
        Contact contact = AppUtilities.printContact(contacts);
        editContact(contact);

        contacts.set((contact.getId() - 1), contact);
        app.runApp(contacts);
        return contacts;
    }

    public static Contact editContact(Contact contact) {
        Print.printWhatToEdit();

        String input;
        boolean isInputInvalid = true;
        System.out.print("\nYour choice: ");

        do {
            input = scn.next();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2") ||
                    input.equalsIgnoreCase("3") || input.equalsIgnoreCase("4")) {
                isInputInvalid = false;
            } else {
                System.out.print("Please enter a valid input: ");
            }
        }
        while (isInputInvalid);

        switch (input) {
            case "1":
                AppUtilities.editName(contact);
                break;
            case "2":
                AppUtilities.editPhoneNumber(contact);
                break;
            case "3":
                AppUtilities.editMail(contact);
                break;
            case "4":
                AppUtilities.editAddress(contact);
                break;
        }

        System.out.println("Continue editing?");
        System.out.print("Your answer (yes/no): ");
        isInputInvalid = true;

        Scanner sc = new Scanner(System.in); //declaring a new scanner, because, at runtime,
                                             // the program skips "input = scn.nextLine()". bugs...
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
            System.out.println("");
            editContact(contact);
        } else {
            System.out.println("\n");
        }

        return contact;
    }
}
