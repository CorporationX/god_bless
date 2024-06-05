package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> userHobbies;

    public User() {
    }

    public User(int id, String name, int age, Set<String> userHobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userHobbies = userHobbies;
    }

    public Map<Integer, String> findHobbyLovers(List<User> users, Set<String> allHobbies) {
        Map<Integer, String> hobbyLovers = new HashMap<Integer, String>();

        for (User user : users) {
            for (String hobby : user.userHobbies) {
                for (String hobbyFromAllHobbies : allHobbies) {
                    if (hobby.equals(hobbyFromAllHobbies)) {
                        hobbyLovers.put(user.id, hobby);
                    }
                }
            }
        }
        return hobbyLovers;
    }
}
