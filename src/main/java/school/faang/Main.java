package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public class User {
        private String name;
        private Integer age;
        private String job;
        private String address;

        public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
            Map<Integer, List<User>> usersMap = new HashMap<>();

            for(User user : usersList) {
                usersMap.computeIfAbsent(user.age, u -> new ArrayList<>()).add(user);
            }
            return usersMap;
        }
    }
}