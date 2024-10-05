package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Alice", 26, "Google", "New York"),
                new User("Alice Johnson", 28, "Amazon", "London"),
                new User("Bob Smith", 34, "Uber", "Amsterdam"),
                new User("Charlie Brown", 30, "Amazon", "New York"),
                new User("Daisy Miller", 25, "Google", "London"),
                new User("Ethan Wright", 29, "Amazon", "New York"),
                new User("Fiona Davis", 31, "Uber", "London"),
                new User("George Wilson", 40, "Uber", "New York"),
                new User("Hannah Clark", 25, "Google", "London"),
                new User("Ian Lewis", 35, "Uber", "New York"),
                new User("Jenna Hall", 27, "Google", "London")
        );

        System.out.println(User.groupUsers(userList));

        Warrior warrior = new Warrior("Peter", 0, 0, 0);
        Archer archer = new Archer("John", 0, 0, 0);
        warrior.attack(archer);
        archer.attack(warrior);
        System.out.println(warrior.name + " is attacked you and you have  " + archer.health + " % left");
        System.out.println(archer.name + " is attacked you and you have  " + warrior.health + " % left");
    }
}
