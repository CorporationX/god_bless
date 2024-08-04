package faang.school.godbless.project3;


import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString
public class User {
    private String name;
    private int age;
    private String placeWork;
    private String address;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    public static Map<Integer, List<User>> groupedUsers(List<User> userList) {
        Map<Integer, List<User>> result = new HashMap<>();
            for (User user : userList){
                int age = user.getAge();
                if(!result.containsKey(age)){
                    result.put(age, new ArrayList<>());
                }
                result.get(age).add(user);
            }
        return result;

    }
    public User(String name, int age, String placeWork, String address){
        if(age > 18 && !name.isEmpty() && VALID_JOBS.contains(placeWork) && VALID_ADDRESS.contains(address)){
            this.age = age;
            this.name = name;
            this.placeWork = placeWork;
            this.address = address;
        }
        else {
            throw new IllegalArgumentException("Argument is not valid");
        }
    }
}


