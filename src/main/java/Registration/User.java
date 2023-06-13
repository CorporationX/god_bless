package Registration;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {

    private String name;

    private Integer age;

    private String workPlace;

    private String address;
    
    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));

    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, Integer age, String workPlace, String address) {

        if (name.isEmpty()){
            throw new IllegalArgumentException("Name can't be empty!");
        } else if (name == null) {
            throw new IllegalArgumentException("Name can't be null!");
        } else {
            this.name = name;
        }

        if (age < 18){
            throw new IllegalArgumentException("Age less than 18! " + age);
        } else {
            this.age = age;
        }

        if (VALID_JOBS.toString().contains(workPlace)){
            this.workPlace = workPlace;
        } else {
            throw new IllegalArgumentException("The place of work is not included in the original composition!");
        }

        if (VALID_ADDRESSES.toString().contains(address)){
            this.address = address;
        } else {
            throw new IllegalArgumentException("Your city is not included in the original composition!");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users){

        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : users){

            Integer age = user.age;

            if (userGroups.containsKey(age)){
                userGroups.get(age).add(user);
            } else {

                List<User> userList = new ArrayList<>();
                userGroups.put(age, userList);
                userList.add(user);

            }
        }
        return userGroups;
    }
}
