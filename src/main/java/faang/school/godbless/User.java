package faang.school.godbless;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.*;

@Data
@EqualsAndHashCode
//@
public class User {
    private int id;
    private String name;
    private int age;
    private ArrayList<String> hobbyList;

    public User (int id, String name, int age, String ... hobbies){
        this.id=id;
        this.name=name;
        this.age=age;
        hobbyList = new ArrayList<>();
        Collections.addAll(hobbyList, hobbies);
    }

    public static Map<User,String> findHobbyFrom(List<String> hobbies, List<User> users){
        Map<User,String> groupedList = new HashMap<>();
        users.forEach(user -> hobbies.forEach(hobby -> {
            if (user.getHobbyList().contains(hobby)){
                groupedList.computeIfAbsent(user, k -> hobby);
            }
        }));
        return groupedList;
    }
}
