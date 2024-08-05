package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User us1 = new User("Andrew", "Uber", "Amsterdam", 19);
        User us2 = new User("Stepan", "Google", "Amsterdam", 25);
        User us3 = new User("Vladislav", "Amazon", "New York", 25);
        User us4 = new User("Alexandr", "Amazon", "London", 22);

        List<User> users = new ArrayList<>();
        users.add(us1);
        users.add(us2);
        users.add(us3);
        users.add(us4);

        User.readingMap(User.groupUsers(users));

        System.out.println();

        Warrior war1 = new Warrior("Dragon knight");
        Archer arch1 = new Archer("Draw ranger");

        war1.attack(arch1);


    }
}
