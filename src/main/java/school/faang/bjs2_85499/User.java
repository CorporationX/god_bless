package school.faang.bjs2_85499;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    private static final int MIN_AGE = 18;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name cannot be empty. You entered: " + name);
        }
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("The age must be at least " + MIN_AGE + ". You entered: " + age);
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Unacceptable place of work: " + job +
                    ". Allowed values: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address + ". Allowed values: " + VALID_ADDRESSES);
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static void main(String[] args) {
        try {
            User ilyas = new User("Ilyas", 31, "Google", "New York");
            System.out.println("OK: " + ilyas);
        } catch (IllegalArgumentException e) {
            System.out.println("BUG: " + e.getMessage());
        }
        try {
            User lena = new User("Lena", 25, "Astronaut", "Ufa");
            System.out.println("OK: " + lena);
        } catch (IllegalArgumentException e) {
            System.out.println("BUG: " + e.getMessage());
        }
        try {
            User sasha = new User("Sasha", 36, "Uber", "Amsterdam");
            System.out.println("OK: " + sasha);
        } catch (IllegalArgumentException e) {
            System.out.println("BUG: " + e.getMessage());
        }
        try {
            User igor = new User("Igor", 28, "Amazon", "London");
            System.out.println("OK: " + igor);
        } catch (IllegalArgumentException e) {
            System.out.println("BUG: " + e.getMessage());
        }
    }
}
