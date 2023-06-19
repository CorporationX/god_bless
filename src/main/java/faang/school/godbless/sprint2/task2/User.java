package faang.school.godbless.sprint2.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String workPlace;
    private String adress;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workPlace, String adress) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Wrong name");
        if (age < 18)
            throw new IllegalArgumentException("Age under 18");
        if (!VALID_JOBS.contains(workPlace))
            throw new IllegalArgumentException("Workplace isn't valid");
        if (!VALID_ADDRESSES.contains(adress))
            throw new IllegalArgumentException("Adress isn't valid");

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.adress = adress;
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
