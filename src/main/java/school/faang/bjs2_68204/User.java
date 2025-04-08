package school.faang.bjs2_68204;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Getter
@Setter
@Slf4j
public class User {
    private String name;
    private int age;
    private String job;
    private String location;

    public User(String name, int age, String job, String location) {
        if (name == null || name.trim().isEmpty()) {
            log.error("Name cannot be null or empty.");
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
        if (age < 0 || age > 110) {
            log.error("Age must be between 0 and 110.");
            throw new IllegalArgumentException("Age must be between 0 and 110.");
        }
        this.age = age;
        if (job == null || job.trim().isEmpty()) {
            log.error("Job cannot be null or empty.");
            throw new IllegalArgumentException("Job cannot be null or empty.");
        }
        this.job = job;
        if (location == null || location.trim().isEmpty()) {
            log.error("Location cannot be null or empty.");
            throw new IllegalArgumentException("Location cannot be null or empty.");
        }
        this.location = location;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userslist) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        for (User user : userslist) {
            int age = user.getAge();
            usersMap.putIfAbsent(age, new ArrayList<>());
            usersMap.get(age).add(user);
        }
        return usersMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}