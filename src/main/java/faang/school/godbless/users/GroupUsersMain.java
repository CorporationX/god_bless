package faang.school.godbless.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static faang.school.godbless.users.User.groupUsers;

public class GroupUsersMain {

    public static void main(String[] args) {
        User user1 = new User("John", 33, "Google Inc.", "street 1");
        User user2 = new User("Eugene", 21, "Microsoft", "street 2");
        User user3 = new User("Jane", 25, "Amazon", "street 3");
        User user4 = new User("Aaron", 33, "Uber", "street 4");
        User user5 = new User("Walter", 21, "Grey Matter", "street 5");
        User user6 = new User("Jessie", 25, "Grey Matter", "street 5");
        List<User> users = new ArrayList<>();
        Collections.addAll(users, user1, user2, user3, user4, user5, user6);

        System.out.println(groupUsers(users));
    }
}
