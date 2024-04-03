package faang.school.godbless.ageGrouping;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Oleg", 22, "programmer", "Somewhere street 21");
        User user2 = new User("Vasia", 21, "programmer", "Somewhere street 22");
        User user3 = new User("Yarik", 21, "programmer", "Somewhere street 20");
        List<User> users = List.of(user1, user2, user3);

        User.groupUsers(users).entrySet().forEach(System.out::println);
    }
}
