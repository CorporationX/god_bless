package faang.school.godbless.JavaBeisic.BJS2_7165;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class Task {
    public static void main(String[] args) {
        Set<String> activities1 = new HashSet<>(Arrays.asList("football", "basketball", "swimming"));
        Set<String> activities2 = new HashSet<>(Arrays.asList("chess", "football", "cycling"));
        Set<String> activities3 = new HashSet<>(Arrays.asList("running", "swimming", "tennis"));

        User user1 = new User(1, "Alice", 25, activities1);
        User user2 = new User(2, "Bob", 30, activities2);
        User user3 = new User(3, "Charlie", 35, activities3);

        List<User> users = Arrays.asList(user1, user2, user3);
        Set<String> hobbies = new HashSet<>(Arrays.asList("football", "tennis"));

        Map<User, String> hobbyLovers = User.findHobbyLovers(users, hobbies);

        for (Map.Entry<User, String> entry : hobbyLovers.entrySet()) {
            System.out.println("User: " + entry.getKey() + ", Matching Hobby: " + entry.getValue());
        }
    }
}

class User{
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
            for (String hobby : hobbies) {
                if (user.getActivities().contains(hobby)) {
                    result.put(user, hobby);
                    break;
                }
            }
        }

        return result;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getActivities() {
        return activities;
    }
}
