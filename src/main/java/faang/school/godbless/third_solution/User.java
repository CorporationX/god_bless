package faang.school.godbless.third_solution;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.*;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private List<String> activities;

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Vadim", 22, Arrays.asList("run", "jump", "swim")));
        users.add(new User(2, "Dmitry", 56, Arrays.asList("play", "jump", "work")));
        users.add(new User(3, "Igor", 34, Arrays.asList("run", "work", "swim")));
        users.add(new User(4, "Radislav", 42, Arrays.asList("play", "cry")));
        users.add(new User(5, "Andrey", 33, Arrays.asList()));

        List<String> possible_activities = new ArrayList<>(Arrays.asList("work", "cry"));

        findHobbyLovers(users, possible_activities);

    }

    public static Map<User, String> findHobbyLovers(List<User> users, List<String> possible_activities) {
        Map<User, String> hobbiLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivities()) {
                if (possible_activities.contains(activity)) {
                    hobbiLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbiLovers;
    }
}