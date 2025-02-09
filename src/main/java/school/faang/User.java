package school.faang;

import java.util.Scanner;

import static school.faang.Addresses.VALID_ADDRESSES;
import static school.faang.Jobs.VALID_JOBS;

public class User {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = console.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Try again");
            return;
        }

        System.out.println("Enter your age");
        int age = console.nextInt();

        if (age <= 0) {
            System.out.println("This is impossible");
            return;
        } else if (age < 18) {
            System.out.println("Sorry, you are too young");
            return;
        }
        console.nextLine();

        System.out.println("Enter your place of work");
        String jobs = console.nextLine().trim();
        if (jobs.isEmpty()) {
            System.out.println("Error");
            return;
        }
        if (VALID_JOBS.contains(jobs)) {
            System.out.println("This company suits us");
        } else {
            System.out.println("This company is not suitable for us");
            return;
        }

        System.out.println("Enter the location of the company");
        String addresses = console.nextLine().trim();

        if (VALID_ADDRESSES.contains(addresses)) {
            System.out.println("This city suits us");
        } else {
            System.out.println("This city is not suitable for us");
            return;
        }
        console.close();
    }
}