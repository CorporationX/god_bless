package school.faang.bjs2_85499;

import java.util.Set;

public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("The age must be at least 18");
        }
        if (!VALID_JOBS.contains(job)) {
            throw new IllegalArgumentException("Unacceptable place of work: " + job);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
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
            System.out.println("ERROR: " + e.getMessage());
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
            System.out.println("ERROR: " + e.getMessage());
        }
        try {
            User igor = new User("Igor", 28, "Amazon", "London");
            System.out.println("OK: " + igor);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "User {" + "name " + name + ", " +
                "age " + age + ", " +
                "job " + job + ", " +
                "address " + address +
                '}';
    }
}
