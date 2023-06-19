package faang.school.godbless.groupUsersByAge;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@ToString
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    private static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || "".equals(name.trim()) || age < 18 || !VALID_JOBS.contains(placeOfWork) ||
                !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Переданы невалидные данные!");
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> usersByAgeMap = new HashMap<>();
        for (User user : userList) {
            if (!usersByAgeMap.containsKey(user.getAge())) {
                usersByAgeMap.put(user.getAge(), new ArrayList<>());
            }

            usersByAgeMap.get(user.getAge()).add(user);
        }

        return usersByAgeMap;
    }
}
