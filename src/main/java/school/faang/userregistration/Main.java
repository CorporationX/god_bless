package school.faang.userregistration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        addUser("Sergey", 21, "Google", "London", users);
        addUser("", 22, "Uber", "London", users);
        addUser("Anton", 17, "Amazon", "Amsterdam", users);
        addUser("Andrey", 24, "Yandex", "London", users);
        addUser("Denis", 25, "Google", "Spb", users);
        addUser("Viktor", 28, "Uber", "New York", users);
        users.forEach(System.out::println);
    }

    private static void addUser(String name, int age, String job, String address, List<User> users) {
        try {
            User user = new User(name, age, job, address);
            users.add(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
