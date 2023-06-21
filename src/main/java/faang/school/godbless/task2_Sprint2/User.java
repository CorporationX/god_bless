package faang.school.godbless.task2_Sprint2;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

@ToString
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>();
    private static final Set<String> VALID_ADDRESSES = new HashSet<>();

    private static void addSets() {
        VALID_JOBS.add("Google");
        VALID_JOBS.add("Uber");
        VALID_JOBS.add("Amazon");

        VALID_ADDRESSES.add("London");
        VALID_ADDRESSES.add("New York");
        VALID_ADDRESSES.add("Amsterdam");
    }

    private String name;
    @Getter
    private int age;
    private String worksPlace;
    private String address;

    public User(String name, int age, String worksPlace, String address) throws IllegalArgumentException {
        if (VALID_JOBS.isEmpty()) {
            addSets();
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Вы не указали имя");
        }
        if (age < 17 || age > 150) {
            throw new IllegalArgumentException("Не верный возраст");
        }
        if (!VALID_JOBS.contains(worksPlace)) {
            throw new IllegalArgumentException("Не верное место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Не верной адрес");
        }
        this.name = name;
        this.age = age;
        this.worksPlace = worksPlace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> sortsUsers = new HashMap<>();
        for (User i : users) {
            sortsUsers.computeIfAbsent(i.getAge(), k -> new LinkedList<>()).add(i);
        }
        return sortsUsers;
    }
}
