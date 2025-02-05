package school.faang.services;

import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name.isEmpty() || name==null)
            throw new IllegalArgumentException("Имя не может быть пустым.");
        this.name = name;

        if (age < 18 || name==null)
            throw new IllegalArgumentException("Вам меньше 18 лет.");
        this.age = age;

        if (!VALID_JOBS.contains(job) || name==null)
            throw new IllegalArgumentException("Указанная работа не соответствует критерию.");
        this.job = job;

        if (!VALID_ADDRESSES.contains(address)|| name==null)
            throw new IllegalArgumentException("Указанный адрес не соответствует критерию.");
        this.address = address;
    }
}
