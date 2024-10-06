package school.faang.registr_user;

import java.util.Scanner;
import java.util.Set;

public class Main {
    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final int AGE_START = 18;

    static boolean created = false;
    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static void main(String[] args) {
        Main main = new Main();

        while (!created) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Name: ");
            main.name = scanner.next();

            System.out.print("Enter Age: ");
            if (scanner.hasNextInt()) {
                main.age = scanner.nextInt();
            } else {
                scanner.next();
                main.age = 0;
            }

            System.out.print("Enter place of work: ");
            main.placeWork = scanner.next();

            System.out.print("Enter address: ");
            main.address = scanner.next();

            if (main.validate()) {
                System.out.println("User successfully created");
                created = true;
            }
        }
    }

    private boolean validate() {
        boolean validation = false;

        try {
            if (name == null || name.isEmpty() || name.isBlank()) {
                throw new IllegalArgumentException("ERROR: not valid name");
            } else if (age < AGE_START) {
                throw new IllegalArgumentException("ERROR: not valid age");
            } else if (placeWork == null || placeWork.isEmpty() || placeWork.isBlank() || !VALID_JOBS.contains(placeWork)) {
                throw new IllegalArgumentException("ERROR: not valid place of work");
            } else if (address == null || address.isEmpty() || address.isBlank() || !VALID_ADDRESSES.contains(address)) {
                throw new IllegalArgumentException("ERROR: not valid address");
            }
            validation = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "\nYour params should follow the rules:\n" +
                    "- Name not to be empty\n" +
                    "- Age must be above 18\n" +
                    "- Work on Google, Uber or Amazon\n" +
                    "- Address London, New York or Amsterdam\n");
        }
        return validation;
    }
}