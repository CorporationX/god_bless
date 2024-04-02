package faang.school.godbless.users_registration;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("something_go_wrong_in_validation");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }
}
