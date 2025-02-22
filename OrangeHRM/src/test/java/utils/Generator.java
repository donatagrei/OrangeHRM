package utils;

import com.github.javafaker.Faker;

public class Generator {

    static Faker faker = new Faker();

    public static String generateFirstName(){
        return faker.harryPotter().character();
    }

    public static String generateLastName(){
        return faker.friends().character();
    }

    public static String generateEmail(){
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateKeywords(){
        return faker.lorem().word();
    }

    public static String generateNotes(){
        return faker.lorem().paragraph(3);
    }




}