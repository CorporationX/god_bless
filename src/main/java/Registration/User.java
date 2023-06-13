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
        checkName(name);
        checkAge(age);
        checkJob(workPlace);
        checkAddress(address);

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public void checkName(String name){
        if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Name can't be empty!");
        }
    }

    public void checkAge(int age){
        if (age < 18){
            throw new IllegalArgumentException("Age less than 18! " + age);
        }
    }

    public void checkJob(String workPlace){
        if (!VALID_JOBS.contains(workPlace)){
            throw new IllegalArgumentException("The place of work is not included in the original composition!");
        }
    }

    public void checkAddress(String address){
        if (!VALID_ADDRESSES.contains(address)){
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
