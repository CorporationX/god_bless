package school.faang.task_43933;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = List.of(
                new User("User1", 20, "workplace1", "address1"),
                new User("User2", 25, "workplace2", "address2"),
                new User("User3", 20, "workplace3", "address3"),
                new User("User4", 40, "workplace4", "address4"),
                new User("User5", 20, "workplace5", "address5"),
                new User("User6", 25, "workplace6", "address6")
        );

        User.groupUsers(users).forEach((userAge, userList) -> {
            System.out.printf("%d:\n", userAge);
            userList.forEach(user -> System.out.printf("\t%s\n", user));
        });
    }

}
