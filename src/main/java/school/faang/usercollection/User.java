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
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    protected static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("User%d{name=%s, activities=%s}", id, name, activities);
    }
}
