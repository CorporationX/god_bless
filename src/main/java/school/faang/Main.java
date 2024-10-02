package school.faang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Igor", 32, "Olenov", "Moscow"));
        users.add(new User("Oleg", 32, "Urin", "Tula"));
        users.add(new User("Evgen", 30, "Policai", "Orenburg"));
        Map<Integer, List<User>>  resultMapUsers = User.groupUsers(users);
    }
}

