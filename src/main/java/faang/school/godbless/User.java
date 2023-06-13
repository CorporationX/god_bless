package faang.school.godbless;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ToString
public class User {

    private String name;
    private int age;
    private String workPlace;
    private String address;

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "NewYork", "Amsterdam"));

    public User(String name, int age, String workPlace, String address) {
        if (name != null || name.isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name is blank");
        }
        if (age >= 18){
            this.age = age;
        } else {
            throw new IllegalArgumentException("Children can't work");
        }
        if (VALID_JOBS.contains(workPlace)){
            this.workPlace = workPlace;
        } else {
            throw new IllegalArgumentException("Not valid workplace");
        }
        if (VALID_ADDRESSES.contains(address)){
            this.address = address;
        } else {
            throw new IllegalArgumentException("Not valid address");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){
        Map<Integer,List<User>> groupUsers = new HashMap<>();
        for (User user: users){
            if (groupUsers.containsKey(user.age)){
                groupUsers.get(user.age).add(user);
            } else {
                groupUsers.put(user.age, new ArrayList<>());
                groupUsers.get(user.age).add(user);
            }
        }
        return groupUsers;
    }
}
