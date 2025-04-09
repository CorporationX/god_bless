package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Users> users = new ArrayList<>();
        users.add(new Users("DONAT", 23, "Uber", "Amsterdam"));
        users.add(new Users("POLAND", 24, "Uber", "London"));
        users.add(new Users("RICKY", 22, "Uber", "Amsterdam"));
        users.add(new Users("ABBY", 19, "Amazon", "Amsterdam"));
        users.add(new Users("DUCK", 100, "Uber", "Amsterdam"));
        users.add(new Users("POLICY", 55, "Google", "New York"));
        users.add(new Users("SAX", 33, "Google", "New York"));
        users.add(new Users("BOLT", 21, "Google", "London"));
        users.add(new Users("QWERTY", 22, "Amazon", "New York"));
        users.add(new Users("ALIC", 18, "Amazon", "New York"));
        users.add(new Users("ALEX", 19, "Amazon", "New York"));

        System.out.println(users);
    }
}