package faang.school.godbless.sprint2.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String adres;

    public User(String name, int age, String workPlace, String adres) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.adres = adres;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> users = new HashMap<>();
        for (int i = 0; i < userList.size(); ++i) {
            if (!users.containsKey(userList.get(i).age)) {
                List<User> user = new ArrayList<>();
                user.add(userList.get(i));
                users.put(userList.get(i).age, user);
            } else {
                List<User> tmp = users.get(userList.get(i).age);
                tmp.add(userList.get(i));
                users.put(userList.get(i).age, tmp);
            }
        }

        return users;
    }
}
