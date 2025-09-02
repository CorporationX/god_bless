package school.faang;

import java.util.HashMap;
import java.util.List;

public class User {

    private String name;
    private int age;
    private int id;
    private String activity;

    public User(String name, int age, int id, String activity) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.activity = activity;
    }

    @SuppressWarnings("checkstyle:WhitespaceAfter")
    public static HashMap<String,String> findHobbyLovers(List<User> users, List<String> activity) {
        HashMap<String, String> suitableUsersactivites = new HashMap<>();
        for (User user : users) {
            String[] userActivities = user.activity.split(" ");
            for (String userActivity : userActivities) {
                if (activity.contains(userActivity)) {
                    suitableUsersactivites.put(user.name, user.activity);
                }
            }

        }
        return suitableUsersactivites;
    }

}
