package school.faang.task_43970;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> hobbyList = List.of("Football", "Hockey", "Tennis", "Curling");

        List<String> tomHobby = List.of("Tennis", "Curling");
        List<String> kattyHobby = List.of("Football", "Hockey");
        List<String> jackHobby = List.of("Curling", "Football");

        User Tom = new User(1, "Tom", 14, tomHobby);
        User Katty = new User(2, "Katty", 17, kattyHobby);
        User Jack = new User(3, "Jack", 23, jackHobby);

        List<User> userList = List.of(Tom, Katty, Jack);

        Map<User, String> map = User.findHobbyLovers(userList, hobbyList);

        for (Map.Entry<User, String> entry : map.entrySet()) {
            System.out.printf("Name: %s, hobby %s%n", entry.getKey().getName(), entry.getValue());
        }

    }
}
