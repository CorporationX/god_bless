package faang.school.godbless.BJS2_18452;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class User {
    private static final Set<String> VALID_JOB = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private static final int VALID_AGE = 18;

    private String name;
    @Getter
    private int age;
    private String workPlace;
    private String workAddress;

    private void checkName(String name) {
        if (!Objects.nonNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Wrong user name!");
        }
    }

    private void checkAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Wrong user age!");
        }
    }

    private void checkWorkPlace(String workPlace) {
        if (!VALID_JOB.contains(workPlace)) {
            throw new IllegalArgumentException("Wrong work place!");
        }
    }

    private void checkWorkAddress(String workAddress) {
        if (!VALID_ADDRESSES.contains(workAddress)) {
            throw new IllegalArgumentException("Wrong work address!");
        }
    }

    public User(String name, int age, String workPlace, String workAddress) {
        checkName(name);
        checkAge(age);
        checkWorkPlace(workPlace);
        checkWorkAddress(workAddress);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.workAddress = workAddress;
    }

    public static Map<Integer, List<User>> groupUserByAge(List<User> users) {
        Map<Integer, List<User>> usersGroupsByAge = new HashMap<>();
        for (User user : users) {
            List<User> ageGroup = usersGroupsByAge.getOrDefault(user.getAge(), new ArrayList<>());
            ageGroup.add(user);
            usersGroupsByAge.put(user.getAge(), ageGroup);
        }
        return usersGroupsByAge;
    }
}
