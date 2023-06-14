package faang.school.godbless.user_registration;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    private String placeOfWork;
    private String address;
    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private final static Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    public static final int ADULTHOOD = 18;

    public User(@NonNull String name, int age, @NonNull String placeOfWork, @NonNull String address) {
        if (dateValidate(name, age, placeOfWork, address)) {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }
    }


    private boolean dateValidate(String name, int age, String company, String location) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < ADULTHOOD) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }
        if (!VALID_JOBS.contains(company)) {
            throw new IllegalArgumentException("This job is not in the list");
        }
        if (!VALID_ADDRESSES.contains(location)) {
            throw new IllegalArgumentException("This address is not in the list");
        }
        return true;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream().collect(Collectors.groupingBy(User::getAge));
    }
}
