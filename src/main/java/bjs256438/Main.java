package bjs256438;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = generateTestData();
        User.groupUsers(users).forEach((age, ageGroup) -> System.out.println("Age: " + age
                + " Age group: " + ageGroup));
    }

    private static List<User> generateTestData() {
        List<User> users = new ArrayList<>();
        users.add(new User("Vasiliy", 31, "IT", "Moscow"));
        users.add(new User("Fyodor", 31, "IT", "Moscow"));
        users.add(new User("Ivan", 23, "Transport", "Moscow"));
        users.add(new User("Alexander", 55, "Production", "Spb"));
        users.add(new User("Nikolay", 31, "Medicine", "Spb"));
        users.add(new User("Symon", 23, "HR", "Volgograd"));
        users.add(new User("Dmitriy", 23, "Legal services", "Tver"));
        users.add(new User("Alexey", 55, "Cleaning", "Novosibirsk"));
        users.add(new User("Grigoriy", 19, "Hotel services", "Kaliningrad"));
        users.add(new User("Eduard", 66, "Development", "Voronezh"));
        users.add(new User("Uriy", 25, "Tourism", "Smolensk"));
        return users;
    }
}
