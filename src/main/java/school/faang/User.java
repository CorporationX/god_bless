package school.faang;

import java.util.*;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private static final int MIN_VALID_AGE = 18;

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        validate(name, age, placeOfWork, address);
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public void validate(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }if (age < MIN_VALID_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Некорректное место работы");
        }if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Некорректный адрес");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();
        for (User user : users) {
            groupUsers.computeIfAbsent(user.getAge(), age -> new ArrayList<>()).add(user);
        }
        return groupUsers;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", placeOfWork='" + placeOfWork + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}