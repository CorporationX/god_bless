package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Alice", 26, "IBM Technologies", "123 Main st, Seattle, WA 988003"));
        userList.add(new User("Alice Johnson", 28, "Tech Corp", "123 Elm St, Springfield"));
        userList.add(new User("Bob Smith", 34, "Health Inc", "456 Oak St, Springfield"));
        userList.add(new User("Charlie Brown", 30, "Finance Co", "789 Pine St, Springfield"));
        userList.add(new User("Daisy Miller", 25, "Education LLC", "101 Maple St, Springfield"));
        userList.add(new User("Ethan Wright", 29, "Marketing Group", "202 Birch St, Springfield"));
        userList.add(new User("Fiona Davis", 31, "Consulting Firm", "303 Cedar St, Springfield"));
        userList.add(new User("George Wilson", 40, "Construction Corp", "404 Walnut St, Springfield"));
        userList.add(new User("Hannah Clark", 25, "Retail Shop", "505 Cherry St, Springfield"));
        userList.add(new User("Ian Lewis", 35, "Real Estate LLC", "606 Spruce St, Springfield"));
        userList.add(new User("Jenna Hall", 27, "Software Solutions", "707 Willow St, Springfield"));

        System.out.println(User.groupUsers(userList).get(25));
    }
}
