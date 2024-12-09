package school.faang;

import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    private static final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    private static final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");

    public User(String name, Integer age, String job, String address) {
        validateFields(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }


    private void validateName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
    }


    private void validateAge(Integer age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18!");
        }
    }

    private void validateJob(String job) {
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("The job must be contained in the VALID_JOBS set.");
        }
    }

    private void validateAddress(String address) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("The address must be contained in the VALID_ADDRESSES set.");
        }
    }

    private void validateFields(String name, Integer age, String job, String address) {

        validateName(name);
        validateAge(age);
        validateJob(job);
        validateAddress(address);

    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", job='"
                + job + '\'' + ", address='" + address + '\'' + '}';
    }
}
