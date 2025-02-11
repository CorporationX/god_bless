package school.faang;

import java.util.Scanner;

import static school.faang.Addresses.VALID_ADDRESSES;
import static school.faang.Jobs.VALID_JOBS;

public class User {
    public static final int MIN_AGE = 18;
    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        if (enterName() || enterAge()) {
            return;
        }

        console.nextLine();

        if (enterJob() || enterAddress()) {
            return;
        }

        console.close();
    }

    private static boolean enterName() {
        System.out.println("Enter your name");
        String name = console.nextLine();
        if (name == null || name.isEmpty()) {

            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Try again");
                return true;
            }
        }
        return false;
    }

    private static boolean enterAge() {
        System.out.println("Enter your age");
        int age = console.nextInt();

        if (age < MIN_AGE) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("Sorry, you are too young");
                return true;
            }
        }
        return false;
    }

    private static boolean enterJob() {
        System.out.println("Enter your place of job");
        String job = console.nextLine().trim();

        if (!VALID_JOBS.contains(job)) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("This company is not suitable for us");
                return true;
            }
        }
        return false;
    }

    private static boolean enterAddress() {
        System.out.println("Enter the location of the company");
        String address = console.nextLine().trim();

        if (!VALID_ADDRESSES.contains(address)) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                System.out.println("This city is not suitable for us");
                return true;
            }
        }
        return false;
    }
}
