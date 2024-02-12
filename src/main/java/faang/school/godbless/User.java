package faang.school.godbless;

import lombok.Data;

import java.util.List;


@Data
public class User {
    public static void main(String[] args) {
        new User("Sara", 21, "Uber", "Amsterdam");
    }

    private String name;
    private Integer age;
    private String job;
    private String address;

    private static List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");

    private static List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.compareTo("") == 0) throw new IllegalArgumentException("Name");
        if (age < 18) throw new IllegalArgumentException("Age");
        if (!VALID_JOBS.contains(job)) throw new IllegalArgumentException("Job");
        if (!VALID_ADDRESSES.contains(address)) throw new IllegalArgumentException("Address");
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
