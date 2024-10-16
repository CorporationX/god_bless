package school.faang.BJS2_31955;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));
    public static final int AGE = 18;
    private String name;
    private int age;
    private String work;
    private String address;

    public User(String name, int age, String address, String work) throws IllegalArgumentException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Поле с именем не может быть пустым");
        }

        if (age < AGE) {
            throw new IllegalArgumentException("Вы должны быть совершеннолетним");
        }

        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Данного города нет в списке предложенных");
        }

        if (!VALID_JOBS.contains(work)) {
            throw new IllegalArgumentException("Данной компании нет в списке предложенных");
        }

        this.name = name;
        this.age = age;
        this.address = address;
        this.work = work;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> userMap = new HashMap<>();

        for (User user : users) {
            if (!userMap.containsKey(user.getAge()) || userMap.get(user.getAge()) == null) {
                List<User> userMapList = new ArrayList<>();
                userMapList.add(user);
                userMap.put(user.getAge(), userMapList);
            } else {
                userMap.get(user.getAge()).add(user);
            }
        }
        return userMap;
    }
}
