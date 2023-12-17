package faang.school.godbless;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities = Set.of("Walking, Swimming, Warhammer 40k, BloodBorne");

    public Map<User, String> findHobbyLovers(List<User> users, Set<String> activities) {
        Map<User, String> mapa = new HashMap<>();
        for (User user: users) {
            for (String active: activities) {
                if(user.activities.contains(active)) {
                    mapa.put(user, active);
                }
            }
        }
        return mapa;
    }
}
