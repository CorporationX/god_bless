package faang.school.godbless.user_registration;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
public class User {

    private String name;
    private int age;
    private String workplace;
    private String address;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int WORKING_AGE = 18;

    public User(String name, int age, String workplace, String address) {

        if(name.isBlank() || age < WORKING_AGE || !VALID_JOBS.contains(workplace)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Please, enter only valid values! \n" +
                    "1. User name cannot be null or empty \n" +
                    "2. Age should be more than " + WORKING_AGE + "\n" +
                    "3. Job or address does not match \n"
                );
        }
        this.name = name;
        this.age = age;
        this.workplace = workplace;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsers(List<User> users) {

        Map<Integer, List<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            groupedUsers.putIfAbsent(user.getAge(), new ArrayList<>());
            groupedUsers.get(user.getAge()).add(user);
        }
        return groupedUsers;
    }
}