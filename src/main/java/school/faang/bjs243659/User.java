package school.faang.bjs243659;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final Integer MIN_AGE = 18;

    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(String name, Integer age, String job, String address) {
        setName(name);
        setAge(age);
        setJob(job);
        setAddress(address);
    }

    public void setName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
            return;
        }
        throw new IllegalArgumentException("Имя не может быть пустым");
    }

    public void setAge(Integer age) {
        if (age >= MIN_AGE) {
            this.age = age;
            return;
        }
        throw new IllegalArgumentException("Возраст не может быть меньше 18");
    }

    public void setJob(String job) {
        if (VALID_JOBS.contains(job)) {
            this.job = job;
            return;
        }
        throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
    }

    public void setAddress(String address) {
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
            return;
        }
        throw new IllegalArgumentException("Место работы должно быть содержится в наборе VALID_JOBS");
    }
}
