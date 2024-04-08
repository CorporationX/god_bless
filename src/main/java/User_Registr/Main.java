package User_Registr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("How many users register?");
        int numberOfUsers = Integer.parseInt(read.readLine());
        List<User> users = new ArrayList<>();

        for (int i = 0; i < numberOfUsers; i++) {
            try {
                User user = new User();
                System.out.println("User №" + (i + 1));
                System.out.println("Enter name: ");
                user.setName(read.readLine());
                System.out.println("Enter age: ");
                user.setAge(Integer.parseInt(read.readLine()));
                System.out.println("Enter job:");
                user.setJob(read.readLine());
                System.out.println("Enter address:");
                user.setAddress(read.readLine());

                users.add(user);
            } catch (NumberFormatException e) {
                System.out.println("Empty age");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            users.add(new User("Sanechka", 22, "Dwarf", "World"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println("Возраст: " + entry.getKey());
            System.out.println("Данные: " + entry.getValue());
        }
    }
}
