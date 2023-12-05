package faang.school.godbless.userregistration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    private String name;
    private Integer age;
    private String job;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, Integer age, String job, String address) {
        validateConstructor(name, age, job, address);
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    private void validateConstructor(String name, Integer age, String job, String address) {
        if(name.isBlank() || name.isEmpty()
        || age < 18
        || !VALID_JOBS.contains(job)
        || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Some of User constructor's arguments non-valid");
        }
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }

}
