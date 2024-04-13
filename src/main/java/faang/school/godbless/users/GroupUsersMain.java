package faang.school.godbless.users;

import java.util.List;

import static faang.school.godbless.users.User.groupUsers;

public class GroupUsersMain {

    public static void main(String[] args) {
        System.out.println(groupUsers(
                List.of(new User("John", 33, "Google Inc.", "street 1"),
                new User("Eugene", 21, "Microsoft", "street 2"),
                new User("Jane", 25, "Amazon", "street 3"),
                new User("Aaron", 33, "Uber", "street 4"),
                new User("Walter", 21, "Grey Matter", "street 5"),
                new User("Jessie", 25, "Grey Matter", "street 5"))
        ));
    }
}
