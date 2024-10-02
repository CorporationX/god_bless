package school.faang;

import lombok.Data;
import java.util.*;

@Data
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workPlace, String address) {
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name is empty");
        }
        if(age < 18){
            throw new IllegalArgumentException("Age is less than 18");
        }
        if(!User.VALID_JOBS.contains(workPlace)){
            throw new IllegalArgumentException("Work place does not exist");
        }
        if(!User.VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Work place does not exist");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : users){
            userMap.computeIfAbsent(user.age, u -> new ArrayList<>()).add(user);
        }
        return userMap;
    }
}
