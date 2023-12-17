package faang.school.godbless.collectusers;

import lombok.*;

import java.util.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;
    private static final int AGE = 18;

    public User(String name, int age, String job, String address) {
        validateConstructor(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int usersAge = user.getAge();
            groupUsers.putIfAbsent(usersAge, new ArrayList<>());
            groupUsers.get(usersAge).add(user);
        }
        return groupUsers;
    }

    private void validateConstructor(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Не корректное имя");
        } else if (age < AGE) {
            throw new IllegalArgumentException("Не корректный возраст");
        } else if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Не корректная работа");
        } else if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Не корректный адресс");
        }
    }
}