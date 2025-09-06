package school.faang.bjs2_85597;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым, введите имя.");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть ниже 18 лет.");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы не входит в пул разрешенных.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес не входит в пул разрешенных.");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}