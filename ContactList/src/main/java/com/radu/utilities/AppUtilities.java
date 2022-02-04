package com.radu.utilities;

import com.radu.contacts.Contact;

import java.util.List;
import java.util.Scanner;

public class AppUtilities {

    static Scanner scn = new Scanner(System.in);
    static Contact contact;

    public static Contact printContact(List<Contact> contacts) {
        Print.printDatabase(contacts);
        System.out.print("\nEnter the index of the contact: ");
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

        contact = contacts.get(indexInt - 1);

        System.out.println("\nName:         " + contact.getFullName());
        System.out.println("Phone number: " + contact.getPhoneNumber());
        System.out.println("Mail address: " + contact.getEmail());
        System.out.println("Full address: " + contact.getAddress());
        System.out.println("\n");

        return contact;
    }


    public static Contact editName(Contact contact) {
        Scanner sc = new Scanner(System.in); //I'm declaring a new object Scanner because of some bugs
        //of Java. When I was trying to use scn at runtime the
        //the program was skipping "name = scn.nextLine();"
        System.out.print("Enter the new name: ");
        String name;
        name = sc.nextLine();
        contact.setFullName(name);

        System.out.println("The name has been changed to \"" + name + "\"\n");
        return contact;
    }


    public static Contact editPhoneNumber(Contact contact) {
        String phoneNumber;
        System.out.print("Enter the new phone number: ");

        Scanner sc = new Scanner(System.in); //The same bug as before, when I was trying to use the static scn
        //the program was skipping "phoneNumber = scn.nextLine()", at
        //runtime.
        phoneNumber = sc.nextLine();

        contact.setPhoneNumber(phoneNumber);
        System.out.println("The phone number has been changed to " + phoneNumber + "\n");

        return contact;
    }


    public static Contact editMail(Contact contact) {
        System.out.print("Enter the new mail: ");

        Scanner sc = new Scanner(System.in); //Same bug as before...
        String mail;
        mail = sc.next();

        contact.setEmail(mail);
        System.out.println("The mail has been changed to \"" + mail + "\"\n");

        return contact;
    }


    public static Contact editAddress(Contact contact) {
        String address;
        System.out.print("Enter the new address: ");

        Scanner sc = new Scanner(System.in); //Same bug as before...
        address = sc.nextLine();

        contact.setAddress(address);
        System.out.println("The address has been changed to \"" + address + "\"\n");
        return contact;
    }
}


