package faang.school.godbless.BJS218596;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class User {
    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String placeWork;
    private String address;

    public User(String name, Integer age, String placeWork, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        } else {
            this.name = name;
        }

        if (age == null || age < 18) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        } else {
            this.age = age;
        }

        if (!VALID_JOBS.contains(placeWork)) {
            throw new IllegalArgumentException("Некорректное место работы. Доступные варианты: " + VALID_JOBS);
        } else {
            this.placeWork = placeWork;
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес. Доступные варианты: " + VALID_ADDRESSES);
        } else {
            this.address = address;
        }

    }

    public Integer getAge() {
        return age;
    }

    public String toString() {
        return String.format("[Name: %s, Age: %d, place work: %s, address: %s]", name, age, placeWork, address);
    }

    public static HashMap<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        HashMap<Integer, ArrayList<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            groupUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return groupUsers;
    }
}