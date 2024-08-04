package faang.school.javacore.registrationuser;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.*;
@ToString
public class User {
    private String name;
    private int age;
    private String PlaceOfWork;
    private String address;
    private static final Set VALID_JOBS = Set.of("Google","Uber","Amazon");
    private static final Set VALID_ADDRESSES = Set.of("London","New York","Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        PlaceOfWork = placeOfWork;
        this.address = address;
    }

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



