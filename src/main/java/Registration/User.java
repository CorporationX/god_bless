package Registration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static Set<String> VALID_JOBS = Stream.of("Google",
            "Uber", "Amazon").collect(Collectors.toCollection(HashSet::new));
    private static Set<String> VALID_ADDRESS = Stream.of("London",
            "New York", "Amsterdam").collect(Collectors.toCollection(HashSet::new));

    public User(String name, int age, String job, String address) throws IllegalAccessException {
        this.name = name;

        if (age < 18) {
            throw new IllegalAccessException();
        } else {
            this.age = age;
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalAccessException();
        } else {
            this.job = job;
        }
        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalAccessException();
        } else {
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersGroupByAge = new HashMap<>();
        List<User> usersList = new ArrayList<>();

        for (User user : users) {
            if(usersGroupByAge.containsKey(user.getAge())) {
            usersList = usersGroupByAge.get(user.getAge());
            usersList.add(user);
            usersGroupByAge.put(user.getAge(), usersList);
            usersList = new ArrayList<>();
            }
            else {
                usersList.add(user);
                usersGroupByAge.put(user.getAge(), usersList);
                usersList = new ArrayList<>();
            }

        }

        return usersGroupByAge;
    }
}
