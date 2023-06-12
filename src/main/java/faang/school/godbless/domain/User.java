package faang.school.godbless.domain;

import lombok.Value;

import java.util.*;
import java.util.stream.Collectors;

@Value
public class User {

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    String name;
    Integer age;
    String job;
    String address;

    public static Map<Integer, List<User>> getGroupUsers(List<User> users) {
        return Objects.isNull(users) ? Collections.emptyMap() : users.stream()
            .filter(Objects::nonNull)
            .filter(User::isAgeJobAddressNonMatch)
            .collect(Collectors.groupingBy(User::getAge));
    }

    private static boolean isAgeJobAddressNonMatch(User user) {
        if (user.getAge() > 18 || VALID_JOBS.stream().anyMatch(userJob -> userJob.equals(user.getJob())) ||
            VALID_ADDRESSES.stream().anyMatch(userAddress -> userAddress.equals(user.getAddress()))) {
            return true;
        } else {
            throw new IllegalArgumentException("Age, job and address does not match");
        }
    }
}
