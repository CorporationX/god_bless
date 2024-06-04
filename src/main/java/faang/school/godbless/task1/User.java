package faang.school.godbless.task1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
@Data
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public User(String name, int age, String workplace, String address) {
        validationUser(name, age, workplace, address);
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {
        Map<Integer, List<User>> groupedUsers = new HashMap<>();
        for(User user : users) {
            int age = user.getAge();
            if(!groupedUsers.containsKey(age)) {
                groupedUsers.put(age, new ArrayList<>());
            }
            groupedUsers.get(age).add(user);
        }
        return groupedUsers;
    }

    private void validationUser(String name, int age, String workplace, String address) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        if (!VALID_JOBS.contains(workplace)) {
            throw new IllegalArgumentException("Invalid workplace");
        }
        if (!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        }

    }

}
