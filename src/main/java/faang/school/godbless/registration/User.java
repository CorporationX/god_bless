package faang.school.godbless.registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final int CHECK_AGE = 18;

    private String name;
    private int age;
    private String work;
    private String adress;

    public User(String name, Integer age, String work, String adress) {

        if (!name.isBlank()) {
            this.name = name;
        } else throw new IllegalArgumentException("Warning1");

        if (age > CHECK_AGE) {
            this.age = age;
        } else throw new IllegalArgumentException("Warning2");

        if (VALID_JOBS.contains(work)) {
            this.work = work;
        } else throw new IllegalArgumentException("Warning3");

        if (VALID_ADDRESSES.contains(adress)) {
            this.adress = adress;
        }
        throw new IllegalArgumentException("Warning4");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {

        Map<Integer, List<User>> usersGroup = new HashMap<>();
        for (User user : listUser) {
            if (!usersGroup.containsKey(user.age)) {
                usersGroup.put(user.age, new ArrayList<>());
            }
            usersGroup.get(user.age).add(user);
        }
        return usersGroup;
    }
}
