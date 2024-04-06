package faang.school.godbless.registration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final List<String> VALID_JOBS =
            new ArrayList<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static final List<String> VALID_ADDRESSES =
            new ArrayList<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Поле name пустое");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст должен быть больше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы не найдено");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Такого адресса нет");
        }

//        boolean condition = name.isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address);
//        if (condition) {
//            throw new IllegalArgumentException();
//        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> group = new HashMap<>();
        for (User user : users) {
            int age = user.age;
            if (!group.containsKey(age)) {
                group.put(age, new ArrayList<>());
            }
            group.get(age).add(user);
        }
        return group;
    }

    @Override
    public String toString() {
        return "name: " + name;
    }
}

