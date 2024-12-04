package school.faang.sprint1.task_43740_regUser;

import java.util.Arrays;
import java.util.List;

public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    public final List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    public final List<String> VALID_ADDRESSES = Arrays.asList("London", "New York", "Amsterdam");

    public static void main(String[] args) throws IllegalArgumentException {
        User user = new User("Maxim", 19, "Google", "London");
    }

    public User(String name, Integer age, String job, String address) {
        if (name != null && age >= 18 && VALID_JOBS.contains(job) && VALID_ADDRESSES.contains(address)) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
