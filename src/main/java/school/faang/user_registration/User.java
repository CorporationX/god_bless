package school.faang.user_registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class User {
    private final String name;
    private int age;
    private String placeOfWork;
    private String address;

    public int getAge() {
        return age;
    }

    public User(String name, int age, String placeOfWork, String address) {
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userGroup = new HashMap<>();
        for (User user : users) {
            Integer userAge = user.getAge();
            userGroup.putIfAbsent(userAge, new ArrayList<>());
            userGroup.get(userAge).add(user);
        }

        return userGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(placeOfWork, user.placeOfWork) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, placeOfWork, address);
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
