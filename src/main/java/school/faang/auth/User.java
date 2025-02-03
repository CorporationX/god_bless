package school.faang.auth;

import java.time.LocalDate;
import java.util.Set;

public class User {
    private final String name;
    private final LocalDate birthDay;
    private final String address;
    private final String job;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam", "Hamburg");

    public User(String name, Integer year, Integer month, Integer day, String address, String job) {
        if (address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be blank.");
        }
        if (job.isBlank()) {
            throw new IllegalArgumentException("Job cannot be blank.");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Invalid job: " + job);
        }
        if (name == null || year == null || month == null || day == null) {
            throw new IllegalArgumentException("Invalid input. Name or date of birth is missing");
        }
        if (LocalDate.of(year, month, day).isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Invalid input. User is too young");
        }
        if (LocalDate.of(year, month, day).isBefore(LocalDate.now().minusYears(120))) {
            throw new IllegalArgumentException("Invalid input. User is already retired");
        }
        this.name = name;
        this.birthDay = LocalDate.of(year, month, day);
        this.address = address;
        this.job = job;
    }

    @Override
    public String toString() {
        return String.format("""
                     Name: %s
                     job: %s
                     date of birth %s
                     address: %s
                     """, name, job, birthDay, address);
    }
}
