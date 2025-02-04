package school.faang.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private final Set<String> VALID_JOBS = new HashSet<>(List.of("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESSES = new HashSet<>(List.of("London", "New York", "Amsterdam"));

    public User(String name, int age, String job, String address) {
        if (name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым.");
        this.name = name;

        if (age < 18)
            throw new IllegalArgumentException("Вам меньше 18 лет.");
        this.age = age;

        if (!VALID_JOBS.contains(job))
            throw new IllegalArgumentException("Указанная работа не соответствует критерию.");
        this.job = job;

        if (!VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Указанный адрес не соответствует критерию.");
        this.address = address;
    }
}
