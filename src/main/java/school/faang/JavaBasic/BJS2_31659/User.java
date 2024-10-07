package school.faang.JavaBasic.BJS2_31659;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
public class User {
    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String placeOfWork;
    private String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18 ) {
            throw new IllegalArgumentException("Возраст должен меньше 18");
        }
        if (placeOfWork == null || placeOfWork.isEmpty() || !VALID_JOBS.contains(placeOfWork)) {
            throw new IllegalArgumentException("Место работы должно быть одним содержаться в: " + VALID_JOBS);
        }
        if (address == null || address.isEmpty() || !VALID_ADDRESSES.contains(placeOfWork)) {
            throw new IllegalArgumentException("Адрес работы должен содержаться : " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.placeOfWork = placeOfWork;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsersByAge = new HashMap<>();
        for (User user : users) {
            int usersAge = user.getAge();
            groupedUsersByAge.putIfAbsent(usersAge, new ArrayList<>());
            groupedUsersByAge.get(usersAge).add(user);
        }
        return groupedUsersByAge;
    }
}
