package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>() {
            {
                add(new User("Alex", 30, "Sberbank", "Moscow"));
                add(new User("Sergey", 27, "Alfa Bank", "Saint Petersburg"));
                add(new User("Alina", 27, "T-bank", "Moscow"));
                add(new User("Alex", 25, "VTB", "Saint Petersburg"));
                add(new User("Kseniya", 31, "VTB", "Samara"));
                add(new User("Kate", 35, "Sberbank", "Kazan"));
                add(new User("Irina", 45, "T-bank", "Yekaterinburg"));
                add(new User("Mary", 45, "Sberbank", "Челябинск"));
                add(new User("Pete", 27, "Alfa Bank", "Chelyabinsk"));
            }
        };

        var groups = User.groupUsers(userList);
        var keys = groups.keySet().stream().sorted(Integer::compareTo).toList();
        for (Integer key : keys) {
            for (User user : groups.get(key)) {
                System.out.println(user);
            }
        }

    }
}
