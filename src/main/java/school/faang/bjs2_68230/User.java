package school.faang.bjs2_68230;

import lombok.ToString;

import java.util.Arrays;

@ToString
public class User {
    private static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    private static final String[] VALID_ADDRESSES = {"London", "New York", "Amsterdam"};

    private String name;
    private Integer age;
    private String job;
    private String address;

    public void setName(String name) throws IllegalArgumentException {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым.");
        }
        this.name = name;
    }

    public void setAge(Integer age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Возраст не может быть меньше 18");
        }
        this.age = age;
    }

    public void setJob(String job) throws IllegalArgumentException {
        if (!Arrays.asList(VALID_JOBS).contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержаться в наборе VALID_JOBS");
        }
        this.job = job;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (!Arrays.asList(VALID_ADDRESSES).contains(address)) {
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
