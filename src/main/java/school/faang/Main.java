package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<User> users = new ArrayList<>() { {
                add(new User("Name1", 19, "Workplace1", "Address1"));
                add(new User("Name2", 18, "Workplace2", "Address2"));
                add(new User("Name3", 19, "Workplace3", "Address3"));
                add(new User("Name4", 39, "Workplace4", "Address4"));
                add(new User("Name5", 19, "Workplace5", "Address5"));
            }
        };

        Map<Integer, List<User>> groupedMap = User.groupUsers(users);
    }
}
