package school.faang.task124;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Stream;

@AllArgsConstructor
public class User {

    private int id;
    @Getter
    private String name;
    private int age ;
    @Getter
    private Set<String> activity;

    public static Map<User, String> findHobbyLovers (List<User> users, Set<String> activity){
        Map<User, String> answer = new HashMap<>();
        for(User user : users){
            for(String userActivity : user.getActivity()){
                if(activity.contains(userActivity)){
                    answer.put(user, userActivity);
                    break ;
                }
            }
        }
        return answer;
    }
}
