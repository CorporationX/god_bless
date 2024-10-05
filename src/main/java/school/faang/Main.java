package school.faang;

import java.util.Scanner;

public class Main {
    static boolean created = false;

    public static void main(String[] args) {

        while (!created) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Name: ");
            String name = scanner.next();

            System.out.print("Enter Age: ");
            int age = 0;
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
            }
            else {
                scanner.next();
            }

            System.out.print("Enter PlaceOfWork: ");
            String placeOfWork = scanner.next();

            System.out.print("Enter Address: ");
            String address = scanner.next();

            new User(name, age, placeOfWork, address);
        }
    }
}