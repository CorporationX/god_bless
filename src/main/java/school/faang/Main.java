package school.faang;

import school.faang.task_44003.User;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Andrew", 25, "Dell", "London"),
                new User("Mike", 31, "Google", "Paris"),
                new User("Sam", 35, "Oracle", "Seattle")
        );
        //Grouping the users by age
        Map<Integer, List<User>> groupOfUsers = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : groupOfUsers.entrySet()) {
            System.out.println("Age: " + entry.getKey());

            //print the users names by age
            for (User user : entry.getValue()) {
                System.out.println("Name: " + user.getName());
            }
        }
    }
}