package faang.school.godbless.agegrouping;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Name1", 18, "Workplace1", "Address1"),
                new User("Name2", 18, "Workplace2", "Address2"),
                new User("Name3", 18, "Workplace3", "Address3"),
                new User("Name4", 21, "Workplace4", "Address4")
        );

        System.out.println(User.groupUsers(userList));
    }
}