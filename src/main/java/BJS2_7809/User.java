package BJS2_7809;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@ToString
public class User {
    private String name;
    private int age;
    private String placeOfJob;
    private String address;
    private static List<String> VALID_JOBS = Arrays.asList("Google", "Uber", "Amazon");
    private static List<String> VALID_ADDRESS = Arrays.asList("London", "New York", "Amsterdam");

    public User(String name, int age, String placeOfJob, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(placeOfJob) || !VALID_ADDRESS.contains(address))
            throw new IllegalArgumentException("Object creation failed validation");
        this.name = name;
        this.age = age;
        this.placeOfJob = placeOfJob;
        this.address = address;
    }
}