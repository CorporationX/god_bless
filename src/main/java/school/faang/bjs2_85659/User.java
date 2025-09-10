package school.faang.bjs2_85659;

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
    private static final int ageMin = 18;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не должно быть пустым");
        }
        if (age < ageMin) {
            throw new IllegalArgumentException("возраст не может быть меньше 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("недопустимое место работы");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("недопустимый город");
        }

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
