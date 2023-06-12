package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> setOfActivities;

    public User(int id, String name, int age, Set<String> setOfActivities) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.setOfActivities = setOfActivities;
    }

    public static Map<User, String> findHobbyLovers(List<User> userList, Set<String> setActivites) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : userList) {
            for (String activity : user.setOfActivities) {
                if (setActivites.contains(activity)) {
                    hobbyLovers.put(user, activity);
                    break;
                }
            }
        }
        return hobbyLovers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (age != user.age) return false;
        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(setOfActivities, user.setOfActivities);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (setOfActivities != null ? setOfActivities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", setOfActivities=" + setOfActivities +
                '}';
    }
}
