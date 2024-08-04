package faang.school.javacore.groupeuserbyage;
import lombok.ToString;

import java.util.*;
@ToString
public class User {
    private String name;
    private int age;
    private String PlaceOfWork;
    private String address;

    static HashMap groupUsers (List <User> listUsers){
        HashMap <Integer,List <User>> hashMapUsers = new HashMap<>();
        for (User user: listUsers){
            if (!(hashMapUsers.containsKey(user.age))){
                hashMapUsers.put(user.age,new ArrayList<>());
            }
            hashMapUsers.get(user.age).add(user);
        }
        return hashMapUsers;
    }
}


