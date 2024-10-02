package school.faang;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(new User("Max", 30, "Amazon", "5th avenue"),
                new User("John", 32, "Google", "3th avenue"),
                new User("Eric", 30, "Meta", "5th avenue"));

        System.out.println(User.groupUsers(users));
    }
}
