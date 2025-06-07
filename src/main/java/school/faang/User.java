package school.faang;

import lombok.Getter;
import java.util.Set;

@Getter
public class User {
    private String name;
    private int age;
    private String job;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        String errorMessage = null;
        if (name.isEmpty()) {
            errorMessage = "Empty name";
        } else if (age <= 18) {
            errorMessage = "Age less than 18";
        } else if (!VALID_JOBS.contains(job)) {
            errorMessage = "Invalid job string";
        } else if (!VALID_ADDRESSES.contains(address)) {
            errorMessage = "Invalid address string";
        }

        if (errorMessage.isEmpty()) {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        } else {
            throw new IllegalArgumentException(errorMessage);
        }

    }


}
