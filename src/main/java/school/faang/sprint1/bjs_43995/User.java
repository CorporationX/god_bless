package school.faang.sprint1.bjs_43995;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> result = new HashMap<>();
        HashSet<Integer> keyList = new HashSet<>();
        List<User> valueList = new ArrayList<>();

        for (User user : users) {
            keyList.add(user.age);
        }

        for (Integer age : keyList) {
            for (User user : users) {
                if (age == user.age) {
                    valueList.add(user);
                }
            }
            result.put(age, valueList);
            valueList = new ArrayList<>();
        }

        return result;
    }
}
