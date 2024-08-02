package faang.school.godbless;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
public class User {

    private Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (age < 18) {
            throw new IllegalArgumentException();
        }

        if (placeOfWork == null || !VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException();
        }

        if (address == null || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static HashMap<Integer, List<User>> sortingUsersByAge(List<User> users) {
        HashMap<Integer, List<User>> usersByAge = new HashMap<>();

        for (User user : users) {
            usersByAge.putIfAbsent(user.getAge(), new ArrayList<>());
            usersByAge.get(user.getAge()).add(user);
        }

        return usersByAge;
    }
}
