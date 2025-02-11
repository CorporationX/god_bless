package school.faang.BJS2_58448;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private final Long id;
    private String name;
    private int age;
    private HashSet<String> hobbies = new HashSet<>();

    public HashMap<User, String> findHobbyLovers(ArrayList<User> users, HashSet<String> hobby) {
        HashMap<User, String> results = new HashMap<>();

        for (User user : users) {
            for (String j : hobby) {
                if (hobbies.contains(j)) {
                    results.put(user, j);
                    break;
                }
            }
        }

        return results;
    }
}