package collect;

import lombok.Data;

import java.util.*;
@Data
public class User {
    private int id;
    private String name;
    private int age;
    private Set<String> activities;

    public static Map<User, String > findHobbyLovers (List<User> users, Set<String> acts){
        Map<User, String> map = new HashMap<>();
        for(User user: users){
            Set<String> set = new HashSet<>(user.activities);
            set.retainAll(acts);
            if(!set.isEmpty()){
                map.put(user,set.stream().findFirst().get());
            }
        }
        return map;
    }
}
