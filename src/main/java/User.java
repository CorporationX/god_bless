import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    public User(String name, int age, String workplace, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age can't be less than 18");
        }
        if (!isValidWorkplace(workplace)) {
            throw new IllegalArgumentException("Invalid workplace");
        }
        if (!isValidAddress(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static boolean isValidAge(int age) {
        return age != 0 && age > 0;
    }

    public static final Set<String> VALID_JOBS;
    public static final Set<String> VALID_ADDRESSES;

    static {
        VALID_JOBS = new HashSet<>();
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES = new HashSet<>();
        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    public static boolean isValidWorkplace(String workplace) {
        return VALID_JOBS.stream()
                .anyMatch(job -> job.equals(workplace));
    }

    public static boolean isValidAddress(String address) {
        return VALID_ADDRESSES.stream()
                .anyMatch(location -> location.equals(address));
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream()
                .filter(user -> isValidAge(user.getAge()))
                .collect(Collectors.groupingBy(User::getAge));
    }
}
