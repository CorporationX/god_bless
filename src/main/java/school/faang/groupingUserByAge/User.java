package school.faang.groupingUserByAge;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Data
@Builder
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final static int MIN_AGE = 18;

    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        fieldValidation(name, age, workplace, address);

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userGroupMap = new HashMap<>();
        userList.forEach(user -> userGroupMap.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user));
        return userGroupMap;
    }

    private static void fieldValidation(String name, int age, String workplace, String address) {
        if (name.isEmpty()) throw new IllegalArgumentException("The name field cannot be empty");
        if (age < MIN_AGE) throw new IllegalArgumentException("The minimum age is 18");
        if (!VALID_JOBS.contains(workplace)) throw new IllegalArgumentException("Invalid workplace: " + workplace);
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Invalid address: " + address);
    }
}
