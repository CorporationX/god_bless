package faang.school.godbless.user;

import lombok.Data;
import lombok.Getter;

import java.util.Set;

@Getter
@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        } else {
            this.age = age;
        }
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве VALID_JOBS");
        } else {
            this.job = job;
        }
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве VALID_ADDRESSES");
        } else {
            this.address = address;
        }
    }
}