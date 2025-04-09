package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("DONAT", 23, "Uber", "Amsterdam"));
        users.add(new User("POLAND", 24, "Uber", "London"));
        users.add(new User("RICKY", 22, "Uber", "Amsterdam"));
        users.add(new User("ABBY", 19, "Amazon", "Amsterdam"));
        users.add(new User("DUCK", 100, "Uber", "Amsterdam"));
        users.add(new User("POLICY", 55, "Google", "New York"));
        users.add(new User("SAX", 33, "Google", "New York"));
        users.add(new User("BOLT", 21, "Google", "London"));
        users.add(new User("QWERTY", 22, "Amazon", "New York"));
        users.add(new User("ALIC", 18, "Amazon", "New York"));
        users.add(new User("ALEX", 19, "Amazon", "New York"));

        System.out.println(users);
    }
}