package collecting.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private final String id;
    private final String name;
    private final int age;
    private final List<String> activity;

    public User(String id, String name, int age, List<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public static Map<User, String> findHobbyLovers(List<User> usersList, List<String> activity2) {
        Map<User, String> mapUser = new HashMap<>();
        for (User user :
                usersList) {
            for (String act:
                 user.activity) {
                if (activity2.contains(act)) {
                    mapUser.put(user, act);
                    break;
                }
            }
        }
        return mapUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<String> activityUser1 = List.of("sleep", "eat");
        User user1 = new User("1111", "Ser", 12, activityUser1);
        List<String> activityUser2 = List.of("sport");
        User user2 = new User("1121", "Vikt", 20, activityUser2);
        List<String> activityUser3 = List.of("sport", "sleep", "eat", "skis");
        User user3 = new User("1131", "Seva", 18, activityUser3);
        List<User> users = List.of(user1, user2, user3);

        List<String> methodActivityList = List.of("sleep", "bike", "run", "swim", "sport");

        System.out.println(User.findHobbyLovers(users, methodActivityList));
    }
}
