package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> user = new ArrayList<>();
        user.add(new User("DONAT", 23, "Uber", "Amsterdam"));
        user.add(new User("POLAND", 24, "Uber", "London"));
        user.add(new User("RICKY", 22, "Uber", "Amsterdam"));
        user.add(new User("ABBY", 19, "Amazon", "Amsterdam"));
        user.add(new User("DUCK", 100, "Uber", "Amsterdam"));
        user.add(new User("POLICY", 55, "Google", "New York"));
        user.add(new User("SAX", 33, "Google", "New York"));
        user.add(new User("BOLT", 21, "Google", "London"));
        user.add(new User("QWERTY", 22, "Amazon", "New York"));
        user.add(new User("ALIC", 18, "Amazon", "New York"));
        user.add(new User("ALEX", 19, "Amazon", "New York"));

        System.out.println(user);
    }
}