package faang.school.godbless;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    static final int DEFAULT_AGE = 18;
    static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    @Getter
    private int age;
    private String workplace;
    private String address;

    public User(String name, Integer age, String workplace, String address) {
        if (name.isBlank() || name.isEmpty() || !VALID_JOBS.contains(workplace) || age < DEFAULT_AGE || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("incorrect arguments");
        } else {
            this.name = name;
            this.age = age;
            this.workplace = workplace;
            this.address = address;
        }
    }

    public static Map<Integer, List<User>> groupedUsers(List<User> users) {
        Map<Integer, List<User>> readyMap = new HashMap<Integer, List<User>>();
        for (User user : users) {
            if (readyMap.containsKey(user.getAge())) {
                readyMap.get(user.getAge()).add(user);
            }
            readyMap.putIfAbsent(user.getAge(),new ArrayList<>());
        }
        return readyMap;
    }
}
