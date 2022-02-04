package com.radu;

import com.radu.contacts.Contact;
import com.radu.utilities.Print;
import com.radu.utilities.options.*;

import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner scn = new Scanner(System.in);

    public void runApp(List<Contact> contacts) {
        Print.printWhatToDo();

        String input;
        boolean isInputInvalid = true;

        System.out.print("\nYour choice: ");


        do {
            input = scn.next();
            if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2") ||
                    input.equalsIgnoreCase("3") || input.equalsIgnoreCase("4") ||
                    input.equalsIgnoreCase("5")) {
                isInputInvalid = false;
            } else {
                System.out.print("Please enter a valid input: ");
            }
        }
        while (isInputInvalid);

        switch (input) {
            case "1":
                Option1.runOption1(contacts); //view all contacts
                break;
            case "2":
                Option2.runOption2(contacts); //view contact's details
                break;
            case "3":
                Option3.runOption3(contacts); //edit a contact's detail
                break;
            case "4":
                Option4.runOption4(contacts); //add a contact
                break;
            case "5":
                Option5.runOption5(contacts); //remove a contact
                break;

        }
    }
}
