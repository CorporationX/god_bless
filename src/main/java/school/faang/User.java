package school.faang;

import lombok.Data;

import static java.lang.Boolean.FALSE;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        this.age = age;

        if (FALSE.equals(Constants.VALID_JOBS.contains(job))) {
            throw new IllegalArgumentException(String.format("Invalid job for: %s user's name: %s", job, name));
        }
        this.job = job;

        if (FALSE.equals(Constants.VALID_ADDRESSES.contains(address))) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
