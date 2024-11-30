import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class User {

    public static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

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
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Invalid workplace");
        }
        if (!VALID_ADDRESSES.contains(address)) {
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


    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream()
                .filter(user -> isValidAge(user.getAge()))
                .collect(Collectors.groupingBy(User::getAge));
    }
}
