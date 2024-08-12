package faang.school.godbless.BJS2_18400;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Setter
@Getter
public class User {
    private String name;
    private int age;
    private final int MATURITY = 18;
    private String job;
    private String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < MATURITY) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве: " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for (User user : users) {
            groupedUsers.computeIfAbsent(user.getAge(), userUnit -> new ArrayList<>()).add(user);
        }
        return groupedUsers;
    }
}
