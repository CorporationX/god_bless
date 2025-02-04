package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        addUsers("Антон", 23, "завод", "Ленина 9");
        addUsers("Вика", 21, "офис", "Степана Разина 4");
        addUsers("Антон", 23, "университет", "Ленина 76");
        addUsers("Антон", 21, "завод", "Гагарина 5");

        printUsersSortAge(User.groupUsers(users));
    }

    public static void addUsers(String name, int age, String workplace, String address) {
        users.add(new User(name, age, workplace, address));
    }

    public static void printUsersSortAge(Map<Integer, List<User>> ageSortUsers) {
        for (Map.Entry<Integer, List<User>> entry : ageSortUsers.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
