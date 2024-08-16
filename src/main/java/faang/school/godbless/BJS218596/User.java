package faang.school.godbless.BJS218596;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String placeWork;
    private final String address;

    public User(String name, Integer age, String placeWork, String address) {
        validateUserData(name, age, placeWork, address);
        this.name = name;
        this.age = age;
        this.placeWork = placeWork;
        this.address = address;
    }

    private void validateUserData(String name, Integer age, String placeWork, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("имя не должно быть пустым");
        }

        if (age == null || age < 18) {
            throw new IllegalArgumentException("Возраст не может быть пустым или меньше 18");
        }

        if (!VALID_JOBS.contains(placeWork)) {
            throw new IllegalArgumentException("Некорректное место работы. Доступные варианты: " + VALID_JOBS);
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес. Доступные варианты: " + VALID_ADDRESSES);
        }
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("[Name: %s, Age: %d, Place work: %s, Address: %s]", name, age, placeWork, address);
    }

    public static Map<Integer, ArrayList<User>> groupUsers(ArrayList<User> users) {
        Map<Integer, ArrayList<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            int age = user.getAge();
            groupUsers.computeIfAbsent(age, k -> new ArrayList<>()).add(user);
        }
        return groupUsers;
    }
}