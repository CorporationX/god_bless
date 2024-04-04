package faang.school.godbless.BJS2_4338;

import lombok.Data;
import java.util.*;

@Data
public class User {
    private String name;
    private int age;
    private String workPlace;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public static Map<Integer, List<User>> groupUsers(List<User> usersList) {
        Map<Integer, List<User>> userGroups = new HashMap<>();

        for (User user : usersList) {
            if (!userGroups.containsKey(user.getAge())) {
                userGroups.put(user.getAge(), new ArrayList<>());
            }
            userGroups.get(user.getAge()).add(user);
        }
        return userGroups;
    }

    public User(String name, int age, String workPlace, String address) {
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;

        if (this.name.isEmpty()){
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (this.age < 18){
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(this.workPlace)){
            throw new IllegalArgumentException("Место работы отсутствует во множестве");
        }
        if (!VALID_ADDRESSES.contains(this.address)){
            throw new IllegalArgumentException("Адрес отсутствует во множестве");
        }
    }
}
