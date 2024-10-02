package school.faang.users_registration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.users_registration.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> testList = List.of(
                new User("Дмитрий", 35, "Google", "London"),
                new User("Сергей", 21, "Uber", "New York"),
                new User("Руслан", 35, "Amazon", "Amsterdam"),
                new User("Антон", 20, "Google", "London"),
                new User("Евгений", 21, "Uber", "New York"),
                new User("Максим", 20, "Amazon", "Amsterdam"),
                new User("Елена", 40, "Google", "New York"),
                new User("Анатолий", 35, "Uber", "London"));
        Map<Integer, ArrayList<User>> testMap = groupUsers(testList);

        for (var entry : testMap.entrySet()) {
            System.out.println("Age group: " + entry.getKey() +
                    " List of Users: " + entry.getValue());
        }
    }
}
