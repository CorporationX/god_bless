package faang.school.godbless;

import lombok.Data;
import lombok.val;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    String name;
    int age;
    String jobPlace;
    String adress;

    public User(String name, int age, String jobPlace, String adress) {
        if (name.isEmpty() && age < 18 && VALID_JOBS.contains(jobPlace) && VALID_ADDRESSES.contains(adress)) {
            this.name = name;
            this.age = age;
            this.jobPlace = jobPlace;
            this.adress = adress;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> matchedHobbyUsers = new HashMap<>();
        for (User user : users) {
            matchedHobbyUsers.put(user.age, users.stream().filter(user1 -> user1.age == user.age).toList());
        }

        return matchedHobbyUsers;
    }
}
