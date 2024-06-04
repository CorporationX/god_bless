package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESS = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        setName(name);
        setAge(age);
        setPlaceOfWork(placeOfWork);
        setAddress(address);
    }

    public void setName(String name) {
        if(name.isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 18) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public void setPlaceOfWork(String placeOfWork) {
        if(!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException();
        }
        this.placeOfWork = placeOfWork;
    }

    public void setAddress(String address) {
        if(!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException();
        }
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        users.forEach(user -> usersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));
        return usersByAge;
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
