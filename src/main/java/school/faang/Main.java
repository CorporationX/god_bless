package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Igor", "Olenov", "Moscow", 32));
        users.add(new User("Oleg", "Urin", "Tula", 32));
        users.add(new User("Evgen", "Policai", "Orenburg", 30));
        Map<Integer, List<User>>  resultMapUsers = User.groupUsers(users);
    }
}

