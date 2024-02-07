package faang.school.godbless.java_core.gpoup_user;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        validUser(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private static void validUser(String name, int age, String job, String address) {
        if (name == null) {
            throw new IllegalArgumentException("Не ввели имя");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Ваш работодатель не подходит");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Ваш город проживания не подходит");
        }
    }
}