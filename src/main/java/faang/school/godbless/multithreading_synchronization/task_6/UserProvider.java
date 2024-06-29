package faang.school.godbless.multithreading_synchronization.task_6;

import java.util.List;

public class UserProvider {
    public static List<User> getUsers(House house) {
        return List.of(
                new User("Alice", house, Role.ASSASSIN),
                new User("Bob", house, Role.ASSASSIN),
                new User("Charlie", house, Role.ASSASSIN),
                new User("David", house, Role.ASSASSIN),
                new User("Emma", house, Role.MAGE),
                new User("Frank", house, Role.MAGE),
                new User("Grace", house, Role.MAGE),
                new User("Hannah", house, Role.MAGE),
                new User("Ivy", house, Role.MARKSMAN),
                new User("Jack", house, Role.MARKSMAN),
                new User("Kate", house, Role.MARKSMAN),
                new User("Liam", house, Role.MARKSMAN),
                new User("Mia", house, Role.FIGHTER),
                new User("Noah", house, Role.FIGHTER),
                new User("Olivia", house, Role.FIGHTER),
                new User("Peter", house, Role.FIGHTER),
                new User("Quinn", house, Role.TANK),
                new User("Rose", house, Role.TANK),
                new User("Sam", house, Role.TANK),
                new User("Tom", house, Role.TANK)
        );
    }
}