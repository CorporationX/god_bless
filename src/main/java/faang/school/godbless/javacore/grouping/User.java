package faang.school.godbless.javacore.grouping;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@ToString
public class User {

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    @Getter
    private final int age;
    private final String placeOfWork;
    private final String address;

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

    public User(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }

        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Место работы должно быть \"Google\", \"Uber\" или \"Amazon\"");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть \"London\", \"New York\" или \"Amsterdam\"");
        }

        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }
}
