package school.faang;

import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (!name.isEmpty() || age < 18 || VALID_JOBS.contains(job) || VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
