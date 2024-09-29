package ru.kraiush.BJS2_18571;

import java.util.Collections;

public class AppUserRegistration {

    public static void main(String[] args) {

        System.out.print(String.join("", Collections.nCopies(80, "-")));

        try {
            UserRegistration user = new UserRegistration(null, "cada", "bra");
            System.out.println("\nUser registration: " + user);
        } catch (IllegalArgumentException e) {
            System.out.println("\nValidation error: " + e.getMessage());
        }

        System.out.print(String.join("", Collections.nCopies(80, "-")));

        try {
            UserRegistration user = new UserRegistration("spark", "\"Google", "Amsterdam");
            System.out.println("\nUser registration: " + user);
        } catch (IllegalArgumentException e) {
            System.out.println("\nValidation error: " + e.getMessage());
        }
    }
}
