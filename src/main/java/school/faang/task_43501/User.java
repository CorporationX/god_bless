package school.faang.task_43501;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private final static int VALID_AGE = 18;
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age < VALID_AGE) {
            throw new IllegalArgumentException("Возраст не может быть меньше " + VALID_AGE);
        }
        this.age = age;
    }

    public void setJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Место работы должно содержится в наборе VALID_JOBS");
        }
        this.job = job;
    }

    public void setAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Адрес должен содержится в наборе VALID_ADDRESSES.");
        }
        this.address = address;
    }
}
