package faang.school.godbless;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@Builder
public class User {

    private String name;

    private Integer age;

    private String company;

    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");

    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private static final int LEGAL_WORKING_AGE = 18;


    public User(String name, Integer age, String company, String address) {

        if (name.isBlank() || age < LEGAL_WORKING_AGE || !VALID_JOBS.contains(company)
                || !VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("Please, enter only valid values");
        }

        this.name = name;
        this.age = age;
        this.company = company;
        this.address = address;
    }

    public static Map<Integer, List<User>> groupUsersByAge(List<User> users) {

        Map<Integer, List<User>> usersMap = new HashMap<>();

        for (User user : users) {
            Integer userAge = user.getAge();

            if (!usersMap.containsKey(userAge)) {
                usersMap.put(userAge, new ArrayList<>());
            }

            usersMap.get(userAge).add(user);
        }
        
        return usersMap;
    }
}
