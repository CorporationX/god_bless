package faang.school.godbless;

import java.util.ArrayList;

import static faang.school.godbless.Main.mainStart;
import static faang.school.godbless.User.groupUsers;

import java.util.Map;
import java.util.Set;
import java.util.List;


public class Application {
    public static void main(String... args) {
        System.out.println("Hello world");

//BJS2-2025
        User user1GroupAge = new User("Vanua", "work", "NN", 10);
        User user2GroupAge = new User("Petua", "work", "NN", 11);
        User user3GroupAge = new User("Misha", "work", "NN", 12);
        User user4GroupAge = new User("Ivan", "work", "NN", 10);
        User user5GroupAge = new User("Petr", "work", "NN", 11);

        List<User> groupAgeusers = List.of(user1GroupAge, user2GroupAge, user3GroupAge, user4GroupAge, user5GroupAge);
        Map<Integer, List<User>> groupAgeUsers = groupUsers(groupAgeusers);
//конец BJS2-2025

        List<User> users = new ArrayList<>();
        Set<String> activity1 = Set.of("Drawing", "Dancing", "Music", "Sport");
        User user1 = new User("Ivan", 14, activity1);
        Set<String> activity2 = Set.of("Dancing", "Music", "Drawing", "Sport");
        User user2 = new User("Sergey", 20, activity2);
        Set<String> activity3 = Set.of("Sport", "Drawing", "Dancing", "Music");
        User user3 = new User("Artem", 35, activity3);
        Set<String> activity4 = Set.of("Learning foreign languages", "Blogging");
        User user4 = new User("Mathew", 23, activity4);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Map<User, String> spisUser = User.findHobbyLovers(users, activity2);

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] reversNum = Example.reverse(numbers);
        for (int j : reversNum) {
            System.out.print(j);


            Main.mainStart();
        }

    }
}
