package faang.school.godbless.java_core.collecting_users;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private int age;
    Set<String> hobbySet;


    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbySet) {
//        Map<User, String> map = new HashMap<>();
//        for (User user : users) {
//            for (String hobby : user.hobbySet) {
//                if (hobbySet.contains(hobby)) {
//                    map.put(user, hobby);
//                    break;
//                }
//            }
//        }
//        return map;


        return users.stream()
                .filter(user -> !Collections.disjoint(user.hobbySet, hobbySet))
                .collect(Collectors.toMap(
                        user -> user,
                        user -> user.hobbySet.stream()
                                .filter(hobbySet::contains)
                                .findFirst()
                                .orElse(null)
                ));
    }
}