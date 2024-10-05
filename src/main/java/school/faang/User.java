package school.faang;

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
    private static Set <String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private String age;
    private String job;
    private String address;

    // private void jobValidation()throws jobValidationException{}

    public User(String name, String age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<String, List<User>> groupUsers(List<User> users) {
        Map<String, List<User>> mapByAge = new HashMap<>();
        for (User user : users) {
            mapByAge.computeIfAbsent(user.age, k -> new ArrayList<>()).add(user);
        }
        return mapByAge;

    }

}

