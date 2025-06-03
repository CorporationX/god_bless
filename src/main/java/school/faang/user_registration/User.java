package school.faang.user_registration;

import lombok.Data;
import java.util.List;

@Data
public class User {
    private String name;
    private int age;
    private String job;
    private String address;

    List<String> VALID_JOBS = List.of("Google", "Uber", "Amazon");
    List<String> VALID_ADDRESSES = List.of("London", "New York", "Amsterdam");

    public User(String name, int age, String job, String address) {
        if (name.isEmpty() || age < 18 || !VALID_JOBS.contains(job) || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Вы не прошли валидацию");
        } else {
            this.name = name;
            this.age = age;
            this.job = job;
            this.address = address;
        }
    }
}
