package faang.school.godbless.group_users;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        var firstUser = new User("Kostya", 17, "Apple", "Somewhere 18");
        var secondUser = new User("Zaur", 19, "Google", "Somewhere 19");
        var thirdUser = new User("Artur", 17, "Facebook", "Somewhere 20");
        var fourthUser = new User("Andrei", 19, "Oracle", "Somewhere 17");
        List<User> userList = List.of(firstUser, secondUser, thirdUser, fourthUser);
        Map<Integer, List<User>> userMap = User.groupUsers(userList);
        System.out.println(userMap);
    }
}
