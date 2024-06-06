package faang.school.godbless.BJS2_7829;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
public class User {
    private final static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google","Uber","Amazon"));
    private final static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London","New York","Amsterdam"));
    private String name;
    private int age;
    private String workAddress;
    private String address;

    public User(String name, int age, String workAddress, String address) {
        if (name.isBlank() || age < 18 || !VALID_JOBS.contains(workAddress) || !VALID_ADDRESSES.contains(address)){
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.workAddress = workAddress;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> userList) {
        return userList.stream().collect(Collectors.groupingBy(user -> user.getAge()));
    }
}
