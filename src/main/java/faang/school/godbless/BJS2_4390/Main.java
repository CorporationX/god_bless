package faang.school.godbless.BJS2_4390;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        User sam = new User("Sam", 21, "Yandex", "Moscow");
        User ivan = new User("Ivan", 28, "Restaurant", "Ufa");
        User maria = new User("Maria", 45, "School", "Samara");
        User natalia = new User("Natalia", 21, "VK", "Saint Petersburg");
        User mihail = new User("Mihail", 28, "Sber", "Moscow");
        User eugen = new User("Eugen", 45, "Theater", "Krasnodar");

        List<User> users = new ArrayList<>();
        users.add(sam);
        users.add(ivan);
        users.add(maria);
        users.add(natalia);
        users.add(mihail);
        users.add(eugen);

        HashMap<Integer, List<User>> usersByAge = User.groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : usersByAge.entrySet()) {
            System.out.println("age = " + entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user.toString());
            }
        }
    }
}
