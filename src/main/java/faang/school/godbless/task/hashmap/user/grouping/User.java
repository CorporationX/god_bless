package faang.school.godbless.task.hashmap.user.grouping;

import lombok.Getter;

import java.util.Set;

@Getter
public class User {
    private final static Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private final static int MINIMUM_AGE = 18;

    private final String name;
    private final int age;
    private final String placeOfJob;
    private final String address;

    public User(String name, int age, String placeOfJob, String address) throws IllegalArgumentException {
        if (name != null && !name.isBlank() && age > MINIMUM_AGE &&
                placeOfJob != null && VALID_JOBS.contains(placeOfJob) &&
                address != null && VALID_ADDRESS.contains(address)) {
            this.name = name;
            this.age = age;
            this.placeOfJob = placeOfJob;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Неверные данные пользователя!");
        }
    }
}
