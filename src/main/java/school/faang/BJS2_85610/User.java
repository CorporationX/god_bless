package school.faang.BJS2_85610;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    public static final Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static final Set<String> VALID_ADDRESSES = new HashSet<>(
            Arrays.asList("London", "New York", "Amsterdam"));

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        this.name = name;
        if (this.name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        this.age = age;
        if (this.age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18.");
        }
        this.job = job;
        if (!VALID_JOBS.contains(this.job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS.");
        }
        this.address = address;
        if (!VALID_ADDRESSES.contains(this.address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES.");
        }
    }
}
