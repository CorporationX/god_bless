package faang.school.godbless.bjs2_413;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@Getter
@ToString
@EqualsAndHashCode
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String placeWork;
    private String address;

    public User(String name, int age, String placeWork, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }

        if (!VALID_JOBS.contains(placeWork)) {
            throw new IllegalArgumentException("место работы должно содержаться во множестве VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("адрес должен содержаться во множестве VALID_ADDRESSES");
        }
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            if (!groupUsers.containsKey(user.getAge())) {
                groupUsers.put(user.getAge(), new ArrayList<>());
            }
            groupUsers.get(user.getAge()).add(user);
        }
        return groupUsers;
    }
}
