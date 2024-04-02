package faang.school.godbless.Userregistration;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private int age;
    private final Set<String> VALID_JOBS = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private final Set<String> VALID_ADDRESS = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    public User(String name,  int age, String job, String address) throws IllegalAccessException {

        if (!name.isEmpty() && age >= 18 && VALID_JOBS.contains(job) && VALID_ADDRESS.contains(address)) {
            this.age = age;
            this.name = name;

        } else {
            throw new IllegalAccessException("Один из параметров не прошел валидацию");
        }
    }
}
