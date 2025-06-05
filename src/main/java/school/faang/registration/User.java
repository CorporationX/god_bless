package school.faang.registration;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Danil Pudovkin
 * @since 05.06.2025
 */
@Data
public class User {

    public static User INVALID = new User();
    private static List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    private static List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private Integer age;
    private String job;
    private String address;

    public User(@NonNull String name, @NonNull Integer age,
                @NonNull String job, @NonNull String address) {
        var exceptionMessages = new ArrayList<String>();
        if (name.isBlank()) {
            exceptionMessages.add("Name cannot be blank");
        }
        if (age < 18) {
            exceptionMessages.add("Age must be at least 18");
        }
        if (!VALID_JOBS.contains(job)) {
            exceptionMessages.add("Invalid job");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            exceptionMessages.add("Invalid address");
        }
        if (!exceptionMessages.isEmpty()) {
            throw new IllegalArgumentException(exceptionMessages.toString());
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private User() {}
}
