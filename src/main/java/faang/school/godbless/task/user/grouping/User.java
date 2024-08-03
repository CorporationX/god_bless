package faang.school.godbless.task.user.grouping;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String placeOfJob;
    private final String address;

    public User(String name, int age, String placeOfJob, String address) throws IllegalArgumentException {
        if(name != null && !name.isBlank() && age > 18 &&
                placeOfJob != null && VALID_JOBS.contains(placeOfJob) &&
                address != null && VALID_ADDRESS.contains(address)) {
            this.name = name;
            this.age = age;
            this.placeOfJob = placeOfJob;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        if(users == null) {
            return null;
        }
        Map<Integer, List<User>> ageUserMap = new HashMap<>();
        users.forEach(user -> ageUserMap.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));

        return ageUserMap;
    }
}
