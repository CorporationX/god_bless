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
    private final int minimumAge = 18;
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        } else  if (age < minimumAge) {
            throw new IllegalArgumentException("Возраст меньше 18 лет недопустим");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы не допустимо");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Место жительства не допустимо");
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
