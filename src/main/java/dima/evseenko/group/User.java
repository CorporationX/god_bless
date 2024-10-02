package dima.evseenko.group;

import lombok.AllArgsConstructor;
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
    private static final int VALID_MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validate(name, age, job, address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validate(String name, int age, String job, String address) {
        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        if(age < VALID_MINIMUM_AGE)
            throw new IllegalArgumentException("Age cannot be less than 18");
        if(!VALID_JOBS.contains(job))
            throw new IllegalArgumentException("Invalid job");
        if(!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Invalid address");
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersMap = new HashMap();

        if(users == null){
            throw new IllegalArgumentException("users is null");
        }

        users.forEach(u -> groupedUsersMap.computeIfAbsent(u.getAge(), k -> new ArrayList<>()).add(u));
        return groupedUsersMap;
    }
}
