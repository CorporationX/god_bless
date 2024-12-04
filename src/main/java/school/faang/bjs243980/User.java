package school.faang.bjs243980;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroups = new HashMap<>();
        for (User user : users) {
            List<User> usersByAge = userGroups.getOrDefault(user.age, new ArrayList<>());
            usersByAge.add(user);
            userGroups.put(user.age, usersByAge);
        }

        return userGroups;
    }

    @Override
    public String toString() {
        return "User{"
                + "address='" + address + '\''
                + ", job='" + job + '\''
                + ", age=" + age
                + ", name='" + name + '\''
                + '}';
    }
}
