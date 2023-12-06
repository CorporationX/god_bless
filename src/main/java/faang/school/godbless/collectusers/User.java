package faang.school.godbless.collectusers;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private String name;
    private int age;
    private String job;
    private String address;

    public User(String name, int age, String job, String address) {
        validateConstructor();
        this.name = name;
        this.age = age;
        this.job = job;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupUsers = new TreeMap<>();
        for (User user : users) {
            if (!groupUsers.containsKey(user.getAge())) {
                groupUsers.put(user.getAge(), new ArrayList<>());
            }
            groupUsers.get(user.getAge()).add(user);
        }
        return groupUsers;
    }
    private void validateConstructor(String name, int age, String job, String address) {
        validate(name);
        validate(age);
        validate(job);
        validate(address);
    }
    private void validateName() {

    }
    private void validateAge() {

    }
    private void validateJob() {

    }
    private void validateAddress() {

    }

}
