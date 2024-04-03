package faang.school.godbless.groupbyage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User(20));
        users.add(new User(19));
        users.add(new User(19));
        users.add(new User(19));
        users.add(new User(21));
        users.add(new User(21));

        Map<Integer, List<User>> result = groupUsers(users);

        for (Map.Entry<Integer, List<User>> entry : result.entrySet()) {
            System.out.println(entry.getKey());
            for (User user : entry.getValue()) {
                System.out.println(user);
            }
        }

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : users) {

            if (!userMap.containsKey(user.getAge())) {
                userMap.put(user.getAge(), new ArrayList<>());
            }

            userMap.get(user.getAge()).add(user);
        }

        return userMap;
    }
}
