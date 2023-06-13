package faang.school.godbless;

import faang.school.godbless.age_group.User;

import java.util.List;

public class Application {
    public static void main(String... args) {
        List<User> users = List.of(
                new User("John", 28, "work1", "address1"),
                new User("Alice", 35, "work2", "address2"),
                new User("Bob", 35, "work3", "address3"),
                new User("Emily", 35, "work4", "address4")
        );

        int expectedMapSize = 2;
        int resultedMapSize = User.groupUsersByAge(users).size();
        int expectedListSize = 1;
        int resultedListSize = User.getListSize(28);
        System.out.println(User.groupUsersByAge(users));



    }
}
