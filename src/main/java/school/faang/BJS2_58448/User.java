package school.faang.BJS2_58448;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class User {
    private Long id;
    private String name;
    private int age;
    private HashSet<String> hobbies = new HashSet<>();

    public HashMap<User, String> findHobbyLovers(ArrayList<User> users, HashSet<String> hobby) {
        HashMap<User, String> results = new HashMap<>();

        for (int i = 0; i < users.size(); i++) {
            for (String j : this.hobbies) {
                if (hobbies.contains(hobby)) {
                    results.put(users.get(i), j);
                    break;
                }
            }
        }

        return results;
    }
}