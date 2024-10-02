package school.faang.task111;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@AllArgsConstructor
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;

    public int getAge() {
        return age;
    }

    public static Map<Integer,List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> answer = new HashMap<>();
        for(User user : users){
            answer.computeIfAbsent(user.getAge(), k->new ArrayList<>()).add(user);
        }
        return answer;
    }


}
