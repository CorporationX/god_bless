package faang.school.godbless.agegrouping;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Name1", 18, "Google", "London"),
                new User("Name2", 18, "Uber", "London"),
                new User("Name3", 18, "Google", "New York"),
                new User("Name4", 21, "Amazon", "Amsterdam")
        );

        System.out.println(User.groupUsers(userList));

        //TestCreatingUserWithAgeUnder18
        try {
            new User("Name5", 17, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("User not created");
        }

        //TestCreatingUserWithBlankName
        try {
            new User("  ", 18, "Google", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("User not created");
        }

        //TestCreatingUserWithNullWorkplace
        try {
            new User("Name7", 18, null, "London");
        } catch (IllegalArgumentException e) {
            System.out.println("User not created");
        }
        //TestCreatingUserWithUndefinedWorkplace
        try {
            new User("Name8", 18, "null", "London");
        } catch (IllegalArgumentException e) {
            System.out.println("User not created");
        }
    }
}