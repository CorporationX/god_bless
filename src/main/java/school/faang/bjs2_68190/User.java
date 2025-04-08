package school.faang.bjs2_68190;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
    private String workplace;
    private String address;

    static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    @Override
    public String toString() {
        return String.format("{name: '%s', age: %d, workplace: '%s', address: '%s'}",
                name, age, workplace, address);
    }
}
