package faang.school.godbless;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {
    private final String name;

    private int age;
    private String workplace;
    private String address;
    private List<String> activities;

    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    static final int LEGAL_AGE = 18;

    public User(String name, int age, String workplace, String address) {
        if (name.isBlank() || age < LEGAL_AGE || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public User(String name, int age, List<String> activities) {
        this.name = name;
        this.age = age;
        this.activities = activities;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public Map<User, String> findHobbyLovers(User[] users, List<String> activities) {
        HashMap<User, String> map = new HashMap<>();

        for (User user : users) {
            for (String userActivity : user.activities) {
                if (activities.contains(userActivity)) {
                    map.put(user, userActivity);
                }
            }
        }

        return map;
    }

    public static User create (String name, int age, String workplace, String address) {
         return new User(name, age, workplace, address);
    }

    public static User create (String name, int age, List<String> activities) {
        return new User(name, age, activities);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
