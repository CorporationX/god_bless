package faang.school.godbless.javaCore;

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
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(workPlace) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Переданы невалидные данные, проверьте условия");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> groupUserByAgeMap = new HashMap<>();
        userList.forEach(user -> groupUserByAgeMap.computeIfAbsent(user.getAge(), v -> new ArrayList<>()).add(user));
        return groupUserByAgeMap;
    }
}