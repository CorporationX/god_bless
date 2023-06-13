package faang.school.godbless.Collectingusers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private int age;
    private String name;
    private Set<String> activities;

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> activities) {
        Map<User, String> mapHobbyLovers = new HashMap<>();

        for (User user : userList) {
            for (String activity : activities) {
                if (user.getActivities().contains(activity)) {
                    mapHobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return mapHobbyLovers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (getId() != user.getId()) return false;
        if (getAge() != user.getAge()) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return getActivities() != null ? getActivities().equals(user.getActivities()) : user.getActivities() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getAge();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getActivities() != null ? getActivities().hashCode() : 0);
        return result;
    }
}
