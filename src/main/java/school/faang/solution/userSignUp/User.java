package school.faang.solution.userSignUp;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");
    private static final int ELIGIBILITY_AGE = 18;

    private String name;
    private int userAge;
    private String company;
    private String address;

    public User (String name, int userAge, String company, String address) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty. Provided value: " + name);
        }

        if (userAge < ELIGIBILITY_AGE) {
            throw new IllegalArgumentException("Age must be at least 18, but was " + userAge);
        }

        boolean validCompany = false;
        for (String job : VALID_JOBS) {
            if (company.contains(job)) {
                validCompany = true;
                break;
            }
        }

        if (!validCompany) {
            throw new IllegalArgumentException("Invalid job: " + company);
        }

        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }

        this.name = name;
        this.userAge = userAge;
        this.company = company;
        this.address = address;
    }

    public int getAge() {
        return userAge;
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
