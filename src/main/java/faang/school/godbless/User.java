package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {
        if (name != null) {
            this.name = name;
        }
        if (age <= 18) {
            this.age = age;
        }
        if (VALID_JOBS.contains(placeOfWork)) {
            this.placeOfWork = placeOfWork;
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        }
        else {
            throw new IllegalArgumentException();
        }

    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(user -> user, Collectors.toList())));
    }
}
