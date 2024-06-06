package faang.school.godbless.group_users_by_age;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user1 = new User("User1", 10, "Company1",
                "Address1");
        User user2 = new User("User2", 15, "Company2",
                "Address2");
        User user3 = new User("User3", 15, "Company3",
                "Address3");
        User user4 = new User("User4", 20, "Company4",
                "Address4");

        System.out.println(User.groupUsers(List.of(user1, user2, user3, user4)));
    }
}
