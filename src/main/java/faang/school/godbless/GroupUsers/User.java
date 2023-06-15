package faang.school.godbless.GroupUsers;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString(includeFieldNames = false)
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Stream.of("Google", "Uber", "Amazon").collect(Collectors.toSet());
    private static final Set<String> VALID_ADDRESSES = Stream.of("London", "New York", "Amsterdam").collect(Collectors.toSet());

    @Getter
    private String name;
    @Getter
    private int age;
    @Getter
    private String work;
    @Getter
    private String city;

    public User(String name, int age, String work, String city) {
        if (name.isBlank() ||
                age < MIN_AGE ||
                !VALID_JOBS.contains(work) ||
                !VALID_ADDRESSES.contains(city)) {
            throw new IllegalArgumentException("Не корректные данные для инициализации.");
        }
        this.name = name;
        this.age = age;
        this.work = work;
        this.city = city;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
