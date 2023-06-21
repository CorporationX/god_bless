package faang.school.godbless.Sprint_2.Task_1_2.reg;

import lombok.Getter;

import java.util.*;

@Getter
public class User {
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfWork, String address) {
        validate(name, age, placeOfWork, address);
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;

    }

    private void validate(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty() || name.isBlank()) throw new IllegalArgumentException("Name is empty");
        if (age < 18) throw new IllegalArgumentException("Too young");
        if (!VALID_JOBS.contains(placeOfWork)) throw new IllegalArgumentException("Work exception");
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Address exception");
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


    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        Map<Integer, List<User>> res = new HashMap<>();
        for (User user : userList) {
            int age = user.getAge();
            res.computeIfPresent(age, (key, value) -> {
                value.add(user);
                return value;
            });
            if (!res.containsKey(age)) {
                List<User> list = new ArrayList<>();
                list.add(user);
                res.put(age, list);
            }

        }
        return res;
    }
}