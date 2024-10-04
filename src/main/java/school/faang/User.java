package school.faang;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class User {
    private static final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));
    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        } else {
            this.name = name;
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        } else {
            this.age = age;
        }
        if (VALID_JOBS.stream().noneMatch(j -> j.equals(job))) {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве VALID_JOBS");
        } else {
            this.job = job;
        }
        if (VALID_ADDRESSES.stream().noneMatch(a -> a.equals(address))) {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве VALID_ADDRESSES");
        } else {
            this.address = address;
        }
    }
}
