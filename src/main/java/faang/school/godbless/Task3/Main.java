package faang.school.godbless.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static faang.school.godbless.Task3.User.groupUsers;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Andrew", 26, "Moscow", "Street1"));
        users.add(new User("John", 25, "Moscow", "Street1"));
        users.add(new User("Jane", 25, "Moscow", "Street1"));
        users.add(new User("Jordan", 26, "Moscow", "Street1"));
        HashMap<Integer, List<User>> ageGroups = groupUsers(users);
        System.out.println(ageGroups);

    }


}
