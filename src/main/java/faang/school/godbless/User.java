package faang.school.godbless;
import lombok.Getter;

import java.util.*;

@Getter
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> result = new HashMap<>();

        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (hobbies.contains(activity)) {
                    result.put(user, activity);
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activities=" + activities +
                '}';
    }

    public static void main(String[] args) {
        Set<String> activities1 = new HashSet<>(Arrays.asList("football", "reading", "swimming"));
        Set<String> activities2 = new HashSet<>(Arrays.asList("dancing", "reading", "chess"));
        Set<String> activities3 = new HashSet<>(Arrays.asList("swimming", "running", "chess"));

        User user1 = new User(1, "Alice", 25, activities1);
        User user2 = new User(2, "Bob", 30, activities2);
        User user3 = new User(3, "Charlie", 22, activities3);

        List<User> users = Arrays.asList(user1, user2, user3);

        Set<String> hobbies = new HashSet<>(Arrays.asList("reading", "running"));

        Map<User, String> hobbyLovers = findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println(entry.getKey() + " loves " + entry.getValue());
        }
    }
}
// test
