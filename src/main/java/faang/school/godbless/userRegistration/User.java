package faang.school.godbless.userRegistration;

import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private final static int MIN_AGE = 18;
    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        this.setName(name);
        this.setAge(age);
        this.setJob(job);
        this.setAddress(address);
    }


    public void setName(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("имя не может быть пустым");
        }

        this.name = name;
    }

    public void setAge(int age) {
        if(age < MIN_AGE) {
            throw new IllegalArgumentException("возраст не может быть меньше " + MIN_AGE);
        }

        this.age = age;
    }

    public void setJob(String job) {
        if(!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("неизвестное место работы");
        }

        this.job = job;
    }

    public void setAddress(String address) {
        if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("неизвестный адрес");
        }

        this.address = address;
    }
}
