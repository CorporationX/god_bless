package faang.school.godbless.GroupByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Boris", 36, "Megafon", "Moskow"));
        users.add(new User("Mihail", 25, "Google", "New York"));
        users.add(new User("Oleg", 36, "Amazon", "London"));
        users.add(new User("Elena", 47, "Uber", "Amsterdam"));
        users.add(new User("Mila", 25, "MTS", "Krasnodar"));
        users.add(new User("Sergey", 32, "Google", "Paris"));

        for (Map.Entry<Integer, List<User>> entry : User.groupUsers(users).entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " Значение: " + entry.getValue());
        }
    }
}