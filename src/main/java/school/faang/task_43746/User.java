package school.faang.task_43746;

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
        validName(name);
        validAge(age);
        validJob(job);
        validAddress(address);

        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Имя не должно быть пустым");
        }
    }

    private void validAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не должен быть меньше 18 лет");
        }
    }

    private void validJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно быть \"Google\" или \"Uber\" или \"Amazon\"");
        }
    }

    private void validAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен быть \"London\", \"New York\", \"Amsterdam\"");
        }
    }
}
