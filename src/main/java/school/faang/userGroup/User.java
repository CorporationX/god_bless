package school.faang.userGroup;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_AGE = 18;

    private String name;
    private String age;
    private String workPlace;
    private String address;

    public User(String name, String age, String workPlace, String address) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("Name can not be empty");
        }
        if (Integer.parseInt(age) > MIN_AGE) {
            throw new IllegalArgumentException("Age can not be lower than 18");
        }
        if (!VALID_JOBS.contains(workPlace)){
            throw new IllegalArgumentException("Invalid work place");
        }
        if(!VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException("Invalid address");
        }
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<String, List<User>> groupUsers(List<User> users) {
        Map<String, List<User>> userGroups = new HashMap<>();

        for (User user : users) {
            if (!userGroups.containsKey(user.getAge())) {
                userGroups.put(user.getAge(), new ArrayList<>());
                userGroups.get(user.getAge()).add(user);
            } else {
                userGroups.get(user.getAge()).add(user);
            }
        }
        return userGroups;
    }
}
