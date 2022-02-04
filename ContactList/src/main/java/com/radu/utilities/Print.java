package com.radu.utilities;

import com.radu.contacts.Contact;

import java.util.List;

public class Print {

    public static void printWelcome() {
        System.out.println(" ██████  ██████  ███    ██ ████████  █████   ██████ ████████     ██      ██ ███████ ████████ \n" +
                "██      ██    ██ ████   ██    ██    ██   ██ ██         ██        ██      ██ ██         ██    \n" +
                "██      ██    ██ ██ ██  ██    ██    ███████ ██         ██        ██      ██ ███████    ██    \n" +
                "██      ██    ██ ██  ██ ██    ██    ██   ██ ██         ██        ██      ██      ██    ██    \n" +
                " ██████  ██████  ██   ████    ██    ██   ██  ██████    ██        ███████ ██ ███████    ██   ");
                 System.out.println("\n");

//        System.out.println("================================");
//        System.out.println("|   Welcome to contact list!   |");
//        System.out.println("================================\n");
    }

    public static void printWhatToDo() {
        System.out.println("Choose you option:");
        System.out.println("1. View your contacts");
        System.out.println("2. View a contact's details");
        System.out.println("3. Edit a contact's details");
        System.out.println("4. Add a contact ");
        System.out.println("5. Remove a contact");

    }


    public static void printDatabase(List<Contact> contacts) {
        Contact contact;

        System.out.println("\n");
        for (int i = 0; i < (getLongestName(contacts) - 8) / 2 + 4; i++) {
            System.out.print(" ");
        }
        System.out.print("Contacts");
        for (int i = 0; i < (getLongestName(contacts) - 8) / 2 + 5; i++) {
            System.out.print(" ");
        }
        System.out.print(" ");


        for (int i = 0; i < (getLongestPhoneNumber(contacts) - 12) / 2 + 3; i++) {
            System.out.print(" ");
        }
        System.out.print("Phone number");
        for (int i = 0; i < (getLongestPhoneNumber(contacts) - 12) / 2; i++) {
            System.out.print(" ");
        }
        System.out.println("");

        for (int i = 0; i < (4 + getLongestName(contacts) + 5 + 3 + getLongestPhoneNumber(contacts) + 3); i++) {
            System.out.print("-");
        }
        System.out.println("");


        for (int i = 0; i < contacts.size(); i++) {
            contact = contacts.get(i);
            int howMuchSmaller = getLongestName(contacts) - contact.getFullName().length();


            if (i < 9) {
                System.out.print(" " + (i + 1) + ". " + contact.getFullName());
            } else {
                System.out.print((i + 1) + ". " + contact.getFullName());
            }
            printContactDetails(contact, howMuchSmaller);
        }
    }

    public static void printContactDetails(Contact contact, int howMuchSmaller) {
        for (int j = 0; j < (howMuchSmaller + 5); j++) {
            System.out.print(" ");
        }
        System.out.print("|   ");
        System.out.print(contact.getPhoneNumber() + "\n");
    }

    public static int getLongestName(List<Contact> contacts) {
        int max = 0;

        for (Contact contact : contacts) {
            if (contact.getFullName().length() > max) {
                max = contact.getFullName().length();
            }
        }

        return max;
    }


    public static int getLongestPhoneNumber(List<Contact> contacts) {
        int max = 0;

        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().length() > max) {
                max = contact.getPhoneNumber().length();
            }
        }

        return max;
    }


    public static void printContact(Contact contact) {
        System.out.println("\nName:         " + contact.getFullName());
        System.out.println("Phone number: " + contact.getPhoneNumber());
        System.out.println("Mail:         " + contact.getEmail());
        System.out.println("Address:      " + contact.getAddress());
    }


    public static void printWhatToEdit() {
        System.out.println("What do you want to edit?");
        System.out.println("1. Name");
        System.out.println("2. Phone number");
        System.out.println("3. Mail address");
        System.out.println("4. Full address");
    }
}
