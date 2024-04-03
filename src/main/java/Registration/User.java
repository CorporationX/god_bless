package Registration;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Getter
@ToString
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private static final int VALID_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) throws IllegalAccessException {

        validationName(name);
        validationAge(age);
        validationJob(job);
        validationAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;

    }

    public void setName(String name) {
        validationName(name);
        this.name = name;
    }

    public void setAge(int age) {
        validationAge(age);
        this.age = age;
    }

    public void setJob(String job) {
        validationJob(job);
        this.job = job;
    }

    public void setAddress(String address) {
        validationAddress(address);
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUser(List<User> users) {
        Map<Integer, List<User>> usersGroupByAge = new HashMap<>();
        List<User> usersList = new ArrayList<>();

        for (User user : users) {

            if (!usersGroupByAge.containsKey(user.getAge())) {
                usersGroupByAge.put(user.getAge(), usersList);
            }

            usersList = usersGroupByAge.get(user.getAge());
            usersList.add(user);
            usersGroupByAge.put(user.getAge(), usersList);
            usersList = new ArrayList<>();

        }

        return usersGroupByAge;
    }

    private static void validationName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Поле имени не должно быть пустым!");
        }
    }

    private static void validationAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст не дольжен быть меньше 18 лет!");
        }
    }

    private static void validationJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Работы нет в списке!");
        }
    }

    private static void validationAddress(String address) {
        if ((!VALID_ADDRESS.contains(address))) {
            throw new IllegalArgumentException("Адреса нет в списке!");
        }
    }
}
