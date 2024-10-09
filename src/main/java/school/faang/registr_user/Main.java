package school.faang.registr_user;

import java.util.Scanner;
import java.util.Set;

public class Main {


    private String name;
    private int age;
    private String placeWork;
    private String address;

    public static void main(String[] args) {

        Main main = new Main();

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

        User user = new User(main.name, main.age, main.placeWork, main.address);
    }
}
