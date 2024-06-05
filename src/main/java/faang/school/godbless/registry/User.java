package faang.school.godbless.registry;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
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
            throw new IllegalArgumentException("Name restriction: Name not must be is empty");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 18) {
            throw new IllegalArgumentException(
                    "Age restriction: Must be at least 18 years old. Provided user {user} age: {user.age}.");
        }
        this.age = age;
    }

    public void setPlaceOfWork(String placeOfWork) {
        if(!VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException(
                    "The place must be valid. Provided {user} placeOfWork: {user.placeOfWork}");
        }
        this.placeOfWork = placeOfWork;
    }

    public void setAddress(String address) {
        if(!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException(
                    "The place must be valid. Provided {user} placeOfWork: {user.placeOfWork}");
        }
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersByAge = new HashMap<>();
        users.forEach(user -> usersByAge.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user));
        return usersByAge;
    }

}
