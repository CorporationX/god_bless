package school.faang.age.grouping;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final static int MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Пользователь не может быть младше 18");
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Не валидное место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Не валидное место проживания");
        }
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
