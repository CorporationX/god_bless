package school.faang.task_43672;

import java.util.Set;

public class User {

    private final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {

        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержатся в наборе VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержатся в наборе VALID_ADDRESSES");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
