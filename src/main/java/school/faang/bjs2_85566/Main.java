package school.faang.bjs2_85566;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        User firstUser = new User("Jim", 19, "office", "Oklahoma");
        User secondUser = new User("Cyntia", 30, "university", "Massachusetts");
        User thirdUser = new User("Dio", 45, "home", "Cairo");
        User fourthUser = new User("Brandon", 19, "hybrid", "Idaho");
        User fifthUser = new User("Hansel", 30, "office", "California");
        User sixthUser = new User("Rose", 45, "home", "Idaho");

        List<User> users = List.of(firstUser, secondUser, thirdUser, fourthUser, fifthUser, sixthUser);
        Map<Integer, List<User>> groupedUsersByAge = User.groupUsersByAge(users);
        groupedUsersByAge.forEach((age, group) -> System.out.println("Age: " + age
                + " -> Group: " + group));
    }
}
