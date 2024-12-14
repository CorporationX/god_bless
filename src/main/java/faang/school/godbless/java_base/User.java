package faang.school.godbless.java_base;

import faang.school.godbless.java_base.exception.ErrorParameterException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    public static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    public static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty()) {
            throw new ErrorParameterException("The name cannot be empty.");
        }
        if (age < 18) {
            throw new ErrorParameterException("The age cannot be less than 18 years old.");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new ErrorParameterException("The place of work must be one of: " + VALID_JOBS);
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new ErrorParameterException("The address must be one of: " + VALID_ADDRESSES);
        }

        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            int age = user.getAge();
            List<User> userList = groupedUsers.getOrDefault(age, new ArrayList<>());
            userList.add(user);
            groupedUsers.put(age, userList);
        }

        return groupedUsers;
    }

}
