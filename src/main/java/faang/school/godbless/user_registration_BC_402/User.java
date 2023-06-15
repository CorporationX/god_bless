package faang.school.godbless.user_registration_BC_402;

import java.util.*;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer age;
    private String company;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int MIN_WORKING_AGE = 18;


    public User(String name, Integer age, String company, String address) {
        if (name.isBlank() || age < MIN_WORKING_AGE || !VALID_JOBS.contains(company)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Пожалуйста, введите корректное значение");
        }
        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            groupUsers.putIfAbsent(age, new ArrayList<>());
            groupUsers.get(age).add(user);
        }
        return groupUsers;
    }
}
