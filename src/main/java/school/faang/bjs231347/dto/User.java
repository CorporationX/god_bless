package school.faang.bjs231347.dto;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Getter
@NonNull
public class User {
    private String name;
    @NonNull
    private final Integer age;
    @NonNull
    private String workPlace;
    @NonNull
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workPlace, String address) throws IllegalArgumentException {
        if (name != null && !name.isBlank()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Поле 'name' не может быть пустым");
        }
        if (age >= 18) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (VALID_JOBS.contains(workPlace)) {
            this.workPlace = workPlace;
        } else {
            throw new IllegalArgumentException("Неподходящее место работы");
        }
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Неподходящий адрес");
        }
    }
    public static Map<Integer, List<User>> groupUsers (List<User> userList) {
        Map<Integer, List<User>> groupResult = new HashMap<>();
        for (User user : userList) {
            if (Objects.nonNull(user)) {
                groupResult.merge(user.getAge(), new LinkedList<>(List.of(user)), (k, v) -> {
                    v.add(user);
                    return v;
                });
            }
        }
        return groupResult;
    }
}
