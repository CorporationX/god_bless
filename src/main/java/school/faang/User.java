package school.faang;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {
    final private String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    final private String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    User(String name, int age, String placeOfWork, String address) {
        if(name == null || name.isEmpty()
            || age < 18 || age > 100
            || !Arrays.asList(VALID_JOBS).contains(placeOfWork)
            || !Arrays.asList(VALID_ADDRESSES).contains(address)) {

            throw new IllegalArgumentException("Name: " + name + ", age: " + age + ", placeOfWork: " + placeOfWork + ", address: " + address);
        }else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new HashMap<>();

        for (User user : users) {
            groupUsers.computeIfAbsent(user.getAge(), k -> new ArrayList<>()).add(user);
        }

        return groupUsers;
    }
}