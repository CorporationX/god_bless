package task.example43667;

import java.util.List;

public class User {
    private static final List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static final Integer MIN_AGE = 18;

    private String name;
    private Integer age;
    private String job;
    private String address;

    User(String name, Integer age, String job, String address) {
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
        throw new IllegalArgumentException("Имя должно содержать хотя бы один символ");
    }

    public void setAge(Integer age) {
        if (age >= MIN_AGE) {
            this.age = age;
            return;
        }
        throw new IllegalArgumentException("Возраст должен быть больше 18");
    }

    public void setJob(String job) {
        if (VALID_JOBS.contains(job)) {
            this.job = job;
            return;
        }
        throw new IllegalArgumentException("Недопустимое место работы");
    }

    public void setAddress(String address) {
        if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
            return;
        }
        throw new IllegalArgumentException("Недопустимый адресс");
    }

}
