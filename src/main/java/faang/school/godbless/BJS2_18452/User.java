package faang.school.godbless.BJS2_18452;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode
@ToString
public class User {
    private static final Set<String> VALID_JOB = new HashSet<>(Set.of("Google", "Uber", "Amazon"));
    private static final Set<String> VALID_ADDRESSES = new HashSet<>(Set.of("London", "New York", "Amsterdam"));

    private String name;
    @Getter
    private int age;
    private String workPlace;
    private String workAddress;


    public User(String name, int age, String workPlace, String workAddress) {
        if (Objects.nonNull(name) && age >= 18 && VALID_JOB.contains(workPlace) && VALID_ADDRESSES.contains(workAddress)) {
            this.name = name;
            this.age = age;
            this.workPlace = workPlace;
            this.workAddress = workAddress;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Map<Integer, List<User>> groupUserByAge(List<User> users) {
        Map<Integer, List<User>> usersGroupsByAge = new HashMap<>();
        for (User user : users) {
            List<User> ageGroup = usersGroupsByAge.getOrDefault(user.getAge(), new ArrayList<>());
            ageGroup.add(user);
            usersGroupsByAge.put(user.getAge(), ageGroup);
        }
        return usersGroupsByAge;
    }
}
