package school.faang;

import java.time.LocalDate;
import java.util.Set;

public class User {
    private String name;
    private LocalDate birthDay;
    private String address;
    private String job;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam", "Hamburg");

    public User(String name, Integer year, Integer month, Integer day, String address, String job) {
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job);
        }
        if (name == null || year == null || month == null || day == null) {
            throw new IllegalArgumentException("Invalid input. Name or date of birth is missing");
        }
        this.name = name;
        this.birthDay = LocalDate.of(year, month, day);
        this.address = address;
        this.job = job;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, job: %s, date of birth %s, address: %s",
                name, job, birthDay, address);
    }
}
