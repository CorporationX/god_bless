package faang.school.godbless.registration;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {
    private String name;
    private Integer age;
    private String work;
    private String address;
    private static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    private static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, Integer age, String work, String address) {
        if (name.isEmpty() | age < 18 |
                !VALID_JOBS.contains(work) | !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.age = age;
        this.work = work;
        this.address = address;
    }
}
