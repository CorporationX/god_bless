package faang.school.godbless.collectUsers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activity;

    public User(int id, String name, int age, Set<String> activity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.activity = activity;
    }

    public Set<String> getActivity() {
        return activity;
    }

    static Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> usersHobbies = new HashMap<>();
        for (User user : users) {
            for (String action : activities) {
                if (user.getActivity().contains(action)) {
                    usersHobbies.put(user, action);
                    break;
                }
            }
        }
        return usersHobbies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activity=" + activity +
                '}';
    }
}
