package javaBasic.bjs2_31713;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    public static final int MINIMUM_AGE = 18;
    public static final Set<String> VALID_JOBS = new HashSet<>(){ {
        add("Google");
        add("Uber");
        add("Amazone");
    }};
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(){ {
        add("London");
        add("New York");
        add("Amsterdam");
    }};

    private int id;
    private String name;
    private int age;
    private List<String> activities;
    private String job;
    private String address;

    public User(int id, String name, int age, List<String> activities, String job, String address) {
        validateUser(name, age, job, address);
        this.id = id;
        this.name = name;
        this.age = age;
        this.activities = activities;
        this.job = job;
        this.address = address;
    }

    private void validateUser(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        if (age < MINIMUM_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + MINIMUM_AGE + ".");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Недопустимая профессия. Допустимые профессии: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Недопустимый адрес. Допустимые адреса: " + VALID_ADDRESSES);
        }
    }

    public static Map<User, String> findHobbyLovers(List<User> users, Set<String> hobbies) {
        Map<User, String> hobbyLovers = new HashMap<>();
        for (User user : users) {
            if (user.getActivities() != null) {
                for (String hobby : hobbies) {
                    if (user.getActivities().contains(hobby)) {
                        hobbyLovers.put(user, user.getName() + hobby);
                        break;
                    }
                }
            }
        }
        return hobbyLovers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", activities=" + activities +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}