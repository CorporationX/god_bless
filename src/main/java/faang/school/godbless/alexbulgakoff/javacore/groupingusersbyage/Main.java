package faang.school.godbless.alexbulgakoff.javacore.groupingusersbyage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Anna", 28, "AlfaStrach", "Moscow"));
        users.add(new User("Igor", 31, "BaltInvest", "Samara"));
        users.add(new User("Vladimir", 24, "MTC", "Moscow"));
        users.add(new User("Nikolay", 31, "RJD", "Saint-Petersburg"));
        users.add(new User("Alexey", 28, "OTP", "Narilsk"));

        System.out.println(User.groupUsers(users));
    }
}
