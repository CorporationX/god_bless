package user.registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of(
            "Google",
            "Uber",
            "Amazon"
    );
    private static final Set<String> VALID_ADDRESSES = Set.of(
            "London",
            "New York",
            "Amsterdam"
    );

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) throws IllegalArgumentException{
        if (
                name.isEmpty()
                || age < 18
                || !VALID_JOBS.contains(workPlace)
                || !VALID_ADDRESSES.contains(address)
        ) {
            throw new IllegalArgumentException("Incorrect parameters!");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if (users == null) {
            return null;
        }
        Map<Integer, List<User>> ageMap = new HashMap<>();
        for(User user : users) {
            if (!ageMap.containsKey(user.getAge())) {
                List<User> userList = new ArrayList<>();
                userList.add(user);
                ageMap.put(user.getAge(), userList);
            }
            else {
                ageMap.get(user.getAge()).add(user);
            }
        }

        return ageMap;
    }
}
