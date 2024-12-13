package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static school.faang.User.groupUsers;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Roman", 35, "Zavod", "Vyhino"));
        users.add(new User("Vasily", 65, "DSK", "Novokosino"));
        users.add(new User("Eugene", 25, "Office", "Seligerskaya"));
        users.add(new User("Oleg", 35, "Yandex", "Park Kultury"));

        Map<Integer, List<User>> usersByAge = groupUsers(users);
        for(Map.Entry<Integer, List<User>> entry : usersByAge.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
