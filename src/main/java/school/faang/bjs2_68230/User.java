package school.faang.bjs2_68230;

import lombok.ToString;

import java.util.List;

@ToString
public class User {
    private static final int MIN_AGE = 18;
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String job;
    private String address;

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        this.name = name;
    }

    public void setAge(Integer age) throws IllegalArgumentException {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException(String.format("Возраст не может быть меньше %s", MIN_AGE));
        }
        this.age = age;
    }

    public void setJob(String job) throws IllegalArgumentException {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS");
        }
        this.job = job;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержаться в наборе VALID_ADDRESSES");
        }
        this.address = address;
    }

    public User(String name, Integer age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }
}
