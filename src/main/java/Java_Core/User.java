package Java_Core;

import lombok.ToString;

import java.util.Set;

@ToString
public class User {
    private String name;
    private int age;
    private String job;
    private String adress;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String adress) throws IllegalArgumentException {
        if (name.isEmpty() || name == null || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(adress)) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.adress = adress;

    }

}
