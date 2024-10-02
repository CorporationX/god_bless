package school.faang.group_users_by_age;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        var users = List.of(
                new User("Antony", 18, "Amazon", "address1"),
                new User("Neo", 22, "Netflix", "address1"),
                new User("Jackson", 21, "Microsoft", "address1"),
                new User("Ronaldo", 18, "Google", "address1")
        );

        System.out.println(User.groupUsers(users, 18));
    }
}
