package faang.school.godbless.BJS27555;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Pavel", 30, "Builder", "London");
        User user2 = new User("Andrei", 22, "Dev", "Moscow");
        User user3 = new User("Alina", 27, "Ingenere", "Omsk");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        Set<Integer> setOfAges = new HashSet<>();
        setOfAges.add(user1.getAge());
        setOfAges.add(user2.getAge());
        setOfAges.add(user3.getAge());


    }
}
