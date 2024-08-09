package faang.school.godbless.BJS2_18484;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Setter
@ToString
@EqualsAndHashCode
public class User {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private static final String INVALID_NAME_MESSAGE = "Name cannot be empty!";
    private static final String INVALID_AGE_MESSAGE = "Age cannot be less than 18!";
    private static final String INVALID_WORK_PLACE_MESSAGE = "Invalid work place!";
    private static final String INVALID_WORK_ADDRESS_MESSAGE = "Invalid work address!";
    private static final int ADULT_AGE = 18;

    private static  Set<String> VALID_JOBS = Set.of("Uber", "Google", "Amazon");
    private static  Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");


    private String name;
    @Getter
    private int age;
    private String workPlace;
    private String workAddress;

    public User(String name, int age, String workPlace, String workAddress) {
        checkName(name);
        checkAge(age);
        checkWorkPlace(workPlace);
        checkWorkAddress(workAddress);
        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.workAddress = workAddress;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));

    }

    private void validate(String message, boolean isValid) {
        if (!isValid) {
            throw new IllegalArgumentException(message);
        }
    }

    private void checkName(String name) {
        validate(INVALID_NAME_MESSAGE, name != null && !name.isBlank() && NAME_PATTERN.matcher(name).matches());
    }

    private void checkAge(int age) {
        validate(INVALID_AGE_MESSAGE, age >= ADULT_AGE);
    }

    private void checkWorkPlace(String workPlace) {
        validate(INVALID_WORK_PLACE_MESSAGE, VALID_JOBS.contains(workPlace));
    }

    private void checkWorkAddress(String workAddress) {
        validate(INVALID_WORK_ADDRESS_MESSAGE, VALID_ADDRESSES.contains(workAddress));
    }
}
