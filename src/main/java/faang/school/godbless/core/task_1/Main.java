package faang.school.godbless.core.task_1;

import faang.school.godbless.core.task_1.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<User> prepareUserGroup() {
        User igor = new User("Igor", 18, "work", "home");
        User petr = new User("Petr", 23, "work", "home");
        User ivan = new User("Ivan", 18, "work", "home");
        User olga = new User("Olga", 16, "no", "home");
        User elena = new User("Elena", 18, "work", "home");
        return List.of(igor, petr, ivan, olga, elena);
    }


    public static void main(String[] args) {
        List<User> users = prepareUserGroup();
        Map<Integer, List<User>> ageUserGroup = groupUsers(users);
        for (Map.Entry<Integer, List<User>> pairs : ageUserGroup.entrySet()) {
            System.out.println(pairs.getKey() + " - " + pairs.getValue());
        }
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> ageUserGroup = new HashMap<>();
        List<User> group;
        for (User user : users) {
            if (!ageUserGroup.containsKey(user.getAge())) {
                group = new ArrayList<>();
            } else {
                group = ageUserGroup.get(user.getAge());
            }
            group.add(user);
            ageUserGroup.put(user.getAge(), group);
        }
        return ageUserGroup;
    }
}