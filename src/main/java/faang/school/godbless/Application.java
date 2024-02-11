package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.User.groupUsers;

public class Application {
    public static void main(String... args) {
        System.out.println("Hello world");

        User user1GroupAge =new User("Vanua","work","NN",10);
        User user2GroupAge =new User("Petua","work","NN",11);
        User user3GroupAge =new User("Misha","work","NN",12);
        User user4GroupAge =new User("Ivan","work","NN",10);
        User user5GroupAge =new User("Petr","work","NN",11);

        List<User> users =List.of(user1GroupAge,user2GroupAge,user3GroupAge,user4GroupAge,user5GroupAge);
        Map<Integer, List<User>> groupAgeUsers = groupUsers(users);
    }
}
