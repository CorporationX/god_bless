package school.faang.userregistration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        try {
            User user = new User("Sergey", 21, "Google", "London");
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user = new User("", 22, "Uber", "London");
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user = new User("Anton", 17, "Amazon", "Amsterdam");
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user = new User("Andrey", 24, "Yandex", "London");
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user = new User("Denis", 25, "Google", "Spb");
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            User user = new User("Viktor", 28, "Uber", "New York");
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        users.forEach(System.out::println);
    }
}
