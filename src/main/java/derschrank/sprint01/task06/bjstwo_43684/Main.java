package derschrank.sprint01.task06.bjstwo_43684;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Ivan", 18, "Uber", "London"));
        list.add(new User("Petr", 19, "Google", "New York"));
        list.add(new User("Sidr", 20, "Amazon", "Amsterdam"));

        try {
            list.add(new User("Ivan", 12, "Uber", "London"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            list.add(new User("Ivan", 18, "Yandex", "London"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            list.add(new User("Ivan", 18, "Uber", "Moscow"));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        System.out.println("We have users: ");
        for (User user : list) {
            System.out.println(user);
        }
    }
}
