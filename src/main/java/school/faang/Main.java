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

        static Map<Integer, List<User>> groupUsers(List<User> usersList) {
            Map<Integer, List<User>> usersMap = new HashMap<>();

            for(User user : usersList) {
                if(!usersMap.containsKey(user.age)) {
                    usersMap.put(user.age, new ArrayList<>());
                }
                usersMap.get(user.age).add(user);
            }
            return usersMap;
        }
    }
}