package school.faang.BJS2_56532;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (isValid(name, age, job, address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Данные пользователя некорректные");
        }
    }

    private boolean isValid(String name, int age, String job, String address) {
        return !name.isEmpty() && age >= 18 && VALID_JOBS.contains(job) && VALID_ADDRESSES.contains(address);
    }
}
