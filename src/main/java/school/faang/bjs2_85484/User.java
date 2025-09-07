package school.faang.bjs2_85484;

import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.ToString;

@Getter
public class User {
    private static int numberOfUsers;

    private int id;
    private String name;
    private int age;
    private Set<String> hobbies;

    public User(String name, int age, Set<String> hobbies) {
        numberOfUsers++;
        this.id = numberOfUsers;
        this.name = name;
        this.age = age;
        this.hobbies = new HashSet<>(hobbies);
    }


    public static Map<User, String> findHobbyLovers(User [] users, Set<String> hobbies) {
        Map<User, String> foundLovers = new HashMap<>();

        for (User u : users) {
            Set<String> retainHobbies = new HashSet<>(u.getHobbies());
            retainHobbies.retainAll(hobbies);
            if (!retainHobbies.isEmpty()) {
                foundLovers.put(u, retainHobbies.toString());
            }
        }

        return foundLovers;
    }
}
