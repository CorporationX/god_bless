package faang.school.godbless;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Саша", 19, new HashSet<>(Arrays.asList("Java", "SQL", "Training"))));
        users.add(new User(2, "Петя", 19, new HashSet<>(Arrays.asList("Java", "SQL"))));
        users.add(new User(3, "Ваня", 20, new HashSet<>(Arrays.asList("Python", "SQL", "Training"))));
        users.add(new User(4, "Вася", 22, new HashSet<>(Arrays.asList("Work", "Training"))));
        users.add(new User(5, "Миша", 20, new HashSet<>(Arrays.asList("Java", "Training", "Cooking"))));

        System.out.println(User.findHobbyLover(users, new HashSet<>(Arrays.asList("SQL","Cooking"))));
        System.out.println(User.findHobbyLover(users, new HashSet<>(Arrays.asList("Cooking"))));
        System.out.println(User.findHobbyLover(users, new HashSet<>()));
    }
}
