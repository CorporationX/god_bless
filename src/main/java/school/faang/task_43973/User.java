package school.faang.task_43973;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {   //Constructor
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> groupedUsers = users.stream().collect(Collectors.toMap(user-> user.getAge(), user -> new ArrayList<>(List.of(user)), (oldList, newList) -> {
            oldList.addAll(newList); 
            return oldList; 
        })); 

        return groupedUsers; 
    }
}
