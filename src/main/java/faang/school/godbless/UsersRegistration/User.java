package faang.school.godbless.UsersRegistration;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String job;
    private String address;


    public User(String name, int age, String job, String address) {
        if(name.trim().isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }
}
