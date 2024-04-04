package faang.school.godbless.groupUsers;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class User {

    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String work, String address) {
        validateParameters(name, age, work, address);

        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }

    //Не знаю, понадобиться ли дальше. Иначе, конечно, удалил бы.
    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }

    private void validateParameters(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty() || age < 18 || !VALID_JOBS.contains(workplace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid user parameters");
        }
    }
}
