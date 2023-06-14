package faang.school.godbless.task1;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
public class User {

    private String name;

    private int age;

    private String workplace;

    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (name.isBlank())
            throw new IllegalArgumentException();
        if (age < 18)
            throw new IllegalArgumentException();
        if (!VALID_JOBS.contains(workplace))
            throw new IllegalArgumentException();
        if (!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException();

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.toList()));
    }
}
