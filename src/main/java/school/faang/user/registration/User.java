package school.faang.user.registration;

import lombok.ToString;

import java.util.List;

@ToString
public class User {

    public static final List<String> VALID_JOBS  = List.of("Google", "Uber", "Amazon");
    public static final List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    private String name;
    private byte age;
    private String job;
    private String address;

    public User(String name, Byte age, String job, String address) {
        if (name == null || name.isBlank() || age < 18 ||
                !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address))
            throw new IllegalArgumentException("Valid error");
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static void main(String[] args) {
        try {
            System.out.println(new User("Iya", (byte) 24, "Uber", "London"));
            System.out.println(new User("Barbie", (byte) 16, "Uber", "London"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
