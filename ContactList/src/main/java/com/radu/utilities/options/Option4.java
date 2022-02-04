package com.radu.utilities.options;

import com.radu.App;
import com.radu.contacts.Contact;
import com.radu.contacts.Database;
import com.radu.utilities.Print;

import java.util.List;
import java.util.Scanner;

public class Option4 {

    static Scanner scn = new Scanner(System.in);
    static App app = new App();

    public static List<Contact> runOption4(List<Contact> contacts) {
        System.out.println("\nAdd a contact");
        String fullName;
        String phoneNumber;
        String mail;
        String address;

        System.out.print("Enter contact's name: ");
        fullName = scn.nextLine();

        System.out.print("Enter contact's phone number: ");
        phoneNumber = scn.nextLine();

        System.out.print("Enter contact's mail: ");
        mail = scn.nextLine();

        System.out.print("Enter contact's address: ");
        address = scn.nextLine();

        //capitalize the name
        fullName = fullName.substring(0, 1).toUpperCase() + fullName.substring(1);


        Contact contact = new Contact((contacts.size() + 1), fullName, phoneNumber, mail, address);

        System.out.println("\nYou are about to enter the following contact: ");
        Print.printContact(contact);

        System.out.print("\nConfirm? Your answer (yes/no): ");
        String answer;
        boolean isInputNotValid = true;

        do {
            answer = scn.nextLine();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                isInputNotValid = false;
            } else {
                System.out.print("Please choose yes or no: ");
            }
        }
        while (isInputNotValid);

        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("\nContact successfully added!\n\n");
        } else {
            editContact(contact, contacts);
            System.out.println("\nContact successfully added!\n\n");

        }

        contacts.add(contact);

        app.runApp(Database.sortContacts(contacts));
        return contacts;
    }


    public static Contact editContact(Contact contact, List<Contact> contacts) {
        System.out.println("\nSelect you option: ");
        System.out.println("1. Edit the details added");
        System.out.println("2. Return to main menu");

        System.out.print("\nYour answer: ");
        boolean isInputNotValid = true;
        String answer;

        do {
            answer = scn.nextLine();
            if (answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("2")) {
                isInputNotValid = false;
            } else {
                System.out.print("Please select 1 or 2: ");
            }
        }
        while (isInputNotValid);

        if (answer.equalsIgnoreCase("1")) {
            Option3.editContact(contact);
        } else {
            app.runApp(contacts);
        }

        System.out.println("You are about to add the following contact: ");
        Print.printContact(contact);

        System.out.print("Confirm? Your answer (yes/no): ");

        isInputNotValid = true;

        do {
            answer = scn.nextLine();
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                isInputNotValid = false;
            } else {
                System.out.print("Please choose yes or no: ");
            }
        }
        while (isInputNotValid);

        System.out.println("");
        if (answer.equalsIgnoreCase("no")) {
            editContact(contact, contacts);
        }

        return contact;
    }
}
