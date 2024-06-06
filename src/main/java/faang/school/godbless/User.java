package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String username;
    private int age;
    private Set<String> activites;

    public User(int id, String username, int age, Set<String> activites) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.activites = activites;
    }

    public Set<String> getActivites() {
        return activites;
    }

    public String getUsername() {
        return username;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            for (String activity : user.getActivites()) {
                if (activites.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

}
