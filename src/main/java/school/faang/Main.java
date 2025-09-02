package school.faang;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        User user1 = new User("Alex", 25, "CompanyA", "Street 1");
        User user2 = new User("Maria", 30, "CompanyB", "Street 2");
        User user3 = new User("Ivan", 25, "CompanyC", "Street 3");
        User user4 = new User("Olga", 30, "CompanyD", "Street 4");
        User user5 = new User("John", 22, "CompanyE", "Street 5");

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

        Map<Integer, List<String>> grouped = User.groupUsers(users);

        for (Map.Entry<Integer, List<String>> entry : grouped.entrySet()) {
            System.out.println("Возраст: " + entry.getKey() + " " + entry.getValue());
        }
    }
}
