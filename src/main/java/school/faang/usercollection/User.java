package school.faang.usercollection;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private final int id;
    private final String name;
    private final int age;
    private final Set<String> activities;

    public User(int id, String name, int age, Set<String> activities) {
        validateInputs(name, activities);

        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> groupedUsers = new HashMap<>();

        for (User user : users) {
            Set<String> userActivities = user.getActivities();
            for (String activity : userActivities) {
                if (activities.contains(activity)) {
                    groupedUsers.put(user, activity);
                    break;
                }
            }
        }

        return groupedUsers;
    }

    private void validateInputs(String name, Set<String> activities) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (activities == null) {
            throw new IllegalArgumentException("Activities is required");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("User%d{name=%s, age=%d, activities=%s}", id, name, age, activities);
    }
}
