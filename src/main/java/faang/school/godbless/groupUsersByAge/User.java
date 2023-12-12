package faang.school.godbless.groupUsersByAge;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@ToString
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESS = new HashSet<>(Arrays.asList("London", "New-York", "Amsterdam"));
    private static final int ADULT_AGE = 18;

    private String name;
    private int age;
    private String placeWork;
    private String address;


    public User(String name, int age, String placeWork, String address) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Incorrect name.");
        }
        if (age >= ADULT_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Incorrect age.");
        }
        if (placeWork != null && VALID_JOBS.contains(placeWork)) {
            this.placeWork = placeWork;
        } else {
            throw new IllegalArgumentException("Incorrect job.");
        }
        if (address != null && VALID_ADDRESS.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Incorrect address.");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> mapGroupUsers = new HashMap<>();
        for (User u : users) {
            List<User> listUsersByAge = new ArrayList<>();
            int age = u.getAge();
            for (User us : users) {
                int ageAnotherUser = us.getAge();
                if (age == ageAnotherUser) {
                    listUsersByAge.add(us);
                }
            }
            mapGroupUsers.put(age, listUsersByAge);
        }
        return mapGroupUsers;
    }
}
