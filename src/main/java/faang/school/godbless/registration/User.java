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
    private String address;

    public User(String name, Integer age, String work, String address) {

        if (!name.isBlank()) {
            this.name = name;
        } else throw new IllegalArgumentException("Warning1");

        if (age > CHECK_AGE) {
            this.age = age;
        } else throw new IllegalArgumentException("Warning2");

        if (VALID_JOBS.contains(work)) {
            this.work = work;
        } else throw new IllegalArgumentException("Warning3");

        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        }
        throw new IllegalArgumentException("Warning4");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", work='" + work + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> listUser) {

        Map<Integer, List<User>> usersGroup = new HashMap<>();
        for (User user : listUser) {
            usersGroup.putIfAbsent(user.age, new ArrayList<>());
            usersGroup.get(user.age).add(user);
        }
        return usersGroup;
    }
}