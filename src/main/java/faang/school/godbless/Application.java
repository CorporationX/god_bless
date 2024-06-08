package faang.school.godbless;

import faang.school.godbless.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activitys) {
        Map<User, String> map = new HashMap<>();
        for (User user : users) {

            for (String activity : user.getActivitys()) {
                if (activitys.contains(activity)) {
                    map.put(user, activity);
                    break;
                }
            }
        }

        return map;
    }
}


