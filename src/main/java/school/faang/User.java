package school.faang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int ADULT_18_AND_MORE = 18;

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        validateUser(name, age, placeOfWork, address);
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    private boolean validateUser(String name, int age, String placeOfWork, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("The name should not be empty");
        }
        if (!(age >= ADULT_18_AND_MORE)) {
            throw new IllegalArgumentException(("Age should be at least  " + ADULT_18_AND_MORE));
        }
        if (!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("The work place should be Google , Uber, Amazon");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The cities addresses should be only in London, New York or Amsterdam");
        }

        return false;
    }

    public int getAge() {
        return age;
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

