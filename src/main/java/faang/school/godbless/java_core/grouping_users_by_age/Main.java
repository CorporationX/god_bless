package faang.school.godbless.java_core.grouping_users_by_age;

import java.util.List;

import static faang.school.godbless.java_core.grouping_users_by_age.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("User_4", 21, "job_4", "address_4"),
                new User("User_10", 23, "job_10", "address_10"),
                new User("User_1", 20, "job_1", "address_1"),
                new User("User_14", 24, "job_14", "address_14"),
                new User("User_3", 20, "job_3", "address_3"),
                new User("User_5", 21, "job_5", "address_5"),
                new User("User_7", 22, "job_7", "address_7"),
                new User("User_12", 24, "job_12", "address_12"),
                new User("User_8", 22, "job_8", "address_8"),
                new User("User_9", 23, "job_9", "address_9"),
                new User("User_11", 24, "job_11", "address_11"),
                new User("User_6", 21, "job_6", "address_6"),
                new User("User_13", 24, "job_13", "address_13"),
                new User("User_2", 20, "job_2", "address_2"),
                new User("User_15", 24, "job_15", "address_15")
        );
        System.out.println(groupUsers(users));
    }
}
