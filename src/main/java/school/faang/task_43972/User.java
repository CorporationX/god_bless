package school.faang.task_43972;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
@Getter
public class User {

    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public User(int id) {
        this.id = id;
        this.name = Utility.getRandomName();
        this.age = Utility.getRandomIntegerWithinRange(20, 23);
        this.activity = Utility.getListWithActivities();
    }

    public static Map<Integer, String> findHobbyLovers(List<User> userList, Set<String> activity) {
        Map<Integer, String> result = new HashMap<>();

        for (User user : userList) {
            Set<String> tempUserActivity = user.getActivity();
            for (String str : tempUserActivity) {
                if (activity.contains(str)) {
                    result.put(user.getId(), str);
                    break;
                }
            }
        }

        return result;
    }
}
