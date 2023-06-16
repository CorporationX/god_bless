package faang.school.godbless.collecting_users;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    int id;
    String name;
    int age;
    Set<String> activitySet;

    User(int id, String name, int age, Set<String> activitySet) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activitySet = activitySet;
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

    public Set<String> getActivitySet() {
        return activitySet;
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> activitySet) {
        Map<User, String> foundMatches = new HashMap<>();
        Iterator<String> it = activitySet.iterator();
        for (User user : users) {
            while (it.hasNext()) {
                if (user.getActivitySet().contains(it.next())) {
                    foundMatches.put(user, it.next());
                    break;
                }
            }
        }
        return foundMatches;
    }
}
