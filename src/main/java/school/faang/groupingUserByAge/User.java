package school.faang.groupingUserByAge;

import lombok.Builder;
import lombok.Data;

import java.util.*;

@Data
@Builder
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (!name.isEmpty() && age >= 18 && VALID_JOBS.contains(workplace) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid user");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> userGroupMap = new HashMap<>();
        userList.forEach(user -> userGroupMap.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user));
        return userGroupMap;
    }
}
