package school.faang.registr_user;

import java.util.Scanner;
import java.util.Set;

public class Main {


    static String name;
    static int age;
    static String placeWork;
    static String address;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        name = scanner.next();

        System.out.print("Enter Age: ");
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
        } else {
            scanner.next();
            age = 0;
        }

        System.out.print("Enter place of work: ");
        placeWork = scanner.next();

        System.out.print("Enter address: ");
        address = scanner.next();

        User user = new User(name, age, placeWork, address);
    }
}
