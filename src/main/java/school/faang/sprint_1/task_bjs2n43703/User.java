package school.faang.sprint_1.task_bjs2n43703;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int MIN_AGE = 18;

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (checkName(name) && checkAge(age) && checkJob(job) && checkAddress(address)) {
            setName(name);
            setAge(age);
            setJob(job);
            setAddress(address);
        }
    }

    public void setName(String name) {
        if (checkName(name)) {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (checkAge(age)) {
            this.age = age;
        }
    }

    public void setJob(String job) {
        if (checkJob(job)) {
            this.job = job;
        }

    }

    public void setAddress(String address) {
        if (checkAddress(address)) {
            this.address = address;
        }
    }

    private boolean checkName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        return true;
    }

    private boolean checkAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("age has to be 18 years and more");
        }
        return true;
    }

    private boolean checkJob(String job) {
        if (VALID_JOBS.contains(job) == false) {
            throw new IllegalArgumentException("job doesn't belong to Set " + VALID_JOBS);
        }
        return true;
    }

    private boolean checkAddress(String address) {
        if (VALID_ADDRESSES.contains(address) == false) {
            throw new IllegalArgumentException("address doesn't belong to Set " + VALID_ADDRESSES);
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age
                + ", job='" + job + '\''
                + ", address='" + address + '\''
                + '}';
    }
}
