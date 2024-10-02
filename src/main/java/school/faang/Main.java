package school.faang;

import school.faang.abstraction.Archer;
import school.faang.abstraction.Character;
import school.faang.abstraction.Warrior;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Nikita", 21, "java Bootcamp", "Voronezh"),
                new User("Vlad", 21, "developer", "Moscow"),
                new User("Dima", 21, "java Bootcamp", "Moscow"),
                new User("Katia", 22, "hospital", "Voronezh"),
                new User("Maxim", 33, "factory", "Moscow")
        );

        System.out.println(users);

        Map<Integer, List<User>> groupUser = User.groupUsers(users);

        System.out.println(groupUser);

        System.out.println("====================");
        System.out.println("====================");

        Character warrior = new Warrior("sven");
        Character archer = new Archer("windranger");

        System.out.println("warrior HP: " + warrior.getHealth());
        System.out.println("archer HP: " + archer.getHealth());

        archer.attack(warrior);
        archer.attack(warrior);

        warrior.attack(archer);

        System.out.println("warrior HP: " + warrior.getHealth());
        System.out.println("archer HP: " + archer.getHealth());
    }
}
