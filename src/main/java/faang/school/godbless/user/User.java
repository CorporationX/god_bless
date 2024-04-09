package faang.school.godbless.user;

import lombok.ToString;

import java.util.Set;
@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        validation(name, age, job, address);
    }

    public void validation(String name, int age, String job, String address) {
        int minimalAge = 18;
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < minimalAge) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + minimalAge);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться во множестве VALID_JOBS");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться во множестве VALID_ADDRESSES");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }
}