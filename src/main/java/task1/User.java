package task1;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;

    private Set<String> stringSet;

    public User(int id, String name, int age, Set<String> stringSet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.stringSet = stringSet;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> stringSets) {
        Map<User, String> userMap = new HashMap<>();
        for (User user : users) {
            for (String s : user.stringSet) {
                if (stringSets.contains(s)) {
                    userMap.put(user, s);
                    break;
                }
            }
        }
        return userMap;
    }
}