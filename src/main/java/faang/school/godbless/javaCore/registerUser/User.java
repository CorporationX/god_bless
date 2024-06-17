package faang.school.godbless.javaCore.registerUser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    private final static Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
    private final static Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        validate(name, age, workPlace, address);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }

    public static void validate(String name, int age, String workPlace, String address) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст должен быть больше " + VALID_AGE);
        }
        if (!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("Передано недопустимое метсто работы - " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Передан недопустимый адрес - " + VALID_ADDRESSES);
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUserByAgeMap = new HashMap<>();
        userList.forEach(user -> groupUserByAgeMap.computeIfAbsent(user.getAge(), v -> new ArrayList<>()).add(user));
        return groupUserByAgeMap;
    }
}