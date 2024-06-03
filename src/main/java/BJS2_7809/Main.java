package BJS2_7809;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        try {
            users.add(new User("Kirill ", 18, "Google", "New York"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            users.add(new User("Ben ", 30, "Google", "Moscow"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            users.add(new User("Kirill ", 16, "Yandex", "London"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        try {
            users.add(new User("Alya ", 19, "Uber", "Amsterdam"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(users);
    }
}