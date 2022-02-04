package com.radu.contacts;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Database {

    static Faker faker = new Faker();

    public static List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();

        Contact contact;
        String funnyName;
        for (int i = 0; i < 50; i++) {
            funnyName = faker.funnyName().name();
            contact = new Contact(
                    (i + 1),
                    funnyName,
                    faker.phoneNumber().phoneNumber(),
                    generateMail(funnyName),
                    faker.address().fullAddress()
            );
            contacts.add(contact);
        }

        sortContacts(contacts);

        return contacts;
    }

    public static String generateMail(String fullName) {
        String mail = fullName.replace(" ", "");
        mail = mail.replace(".", "");
        mail = mail.toLowerCase();

        return mail + "@gmail.com";
    }


    public static List<Contact> sortContacts(List<Contact> contacts) {
        Contact auxContact;
        String letterFirst;
        String secondLetter;


        for (int i = 0; i < contacts.size() - 1; i++) {
            for (int j = 0; j < contacts.size() - i - 1; j++) {
                letterFirst = contacts.get(j).getFullName();
                secondLetter = contacts.get(j + 1).getFullName();

                if (letterFirst.compareTo(secondLetter) > 0) {
                    auxContact = contacts.get(j);
                    contacts.set(j, contacts.get(j + 1));
                    contacts.set(j + 1, auxContact);
                }
            }
        }

        return contacts;
    }


}
