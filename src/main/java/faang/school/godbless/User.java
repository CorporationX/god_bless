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

    public User(int id, String name, int age, Set<String> userHobbies) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userHobbies = userHobbies;
    }

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> allHobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();

        for (User user : users) {
           for (String hobby : user.userHobbies) {
               if(allHobbies.contains(hobby)) {
                   hobbyLovers.put(user, hobby);
               }
           }
        }
        return hobbyLovers;
    }

    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }
}
