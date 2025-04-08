package school.faang.bjs243682;

public class User {

    private static final String[] VALID_JOBS = {"Google", "Uber", "Amazon"};
    private static final String[] ADDRESS = {"London", "New York", "Amsterdam"};
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 99;

    private final String name;
    private final int age;
    private final String job;
    private final String address;

    public User(String name, int age, String job, String address) {
        validateName(name);
        this.name = name;
        validateAge(age);
        this.age = age;
        validateJob(job);
        this.job = job;
        validateAddress(address);
        this.address = address;
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    private void validateAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    private void validateJob(String job) {
        for (String validJob : VALID_JOBS) {
            if (validJob.equals(job)) {
                return;
            }
        }
        throw new IllegalArgumentException("Invalid job");
    }

    private void validateAddress(String address) {
        for (String validAddress : ADDRESS) {
            if (validAddress.equals(address)) {
                return;
            }
        }
        throw new IllegalArgumentException("Invalid address");
    }

    @Override
    public String toString() {
        return String.format("User{name='%s', age=%d, job='%s', address='%s'}", name, age, job, address);
    }
}
