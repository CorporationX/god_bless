package school.faang.task_43942;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
            new User("Name1", 12, "workplace1", "address1"),
            new User("Name2", 22, "workplace2", "address2"),
            new User("Name3", 32, "workplace3", "address3"),
            new User("Name4", 32, "workplace4", "address4"),
            new User("Name5", 12, "workplace5", "address5")
        );

        System.out.println(User.groupUsers(users));
    }
}
