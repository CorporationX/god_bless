package school.faang.task_43503;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();

        users.add(new User("Anton", 18, "Sparkasse", "SonnenStrasse"));
        users.add(new User("Oleg", 24, "Depo", "Rorsi"));
        users.add(new User("Roma", 26, "FastSolutions", "Rorsi"));
        users.add(new User("Max", 24, "School", "Rorsi"));
        users.add(new User("Misha", 18, "Google", "RinderStrasse"));

        User.GroupUsers(users).forEach((key, entity) -> System.out.println(key + ":" + entity));
    }


}
