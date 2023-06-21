package faang.school.godbless.task1_Sprint2;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@ToString
@AllArgsConstructor
public class User {
    private String name;
    @Getter
    private int age;
    private String worksPlace;
    private String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> sortsUsers= new HashMap<>();
        for (User i : users){
            sortsUsers.computeIfAbsent(i.getAge(), k -> new LinkedList<>()).add(i);
        }
        return sortsUsers;
    }
}