package school.faang.solution.userSignUp;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class User {
    private String name;
    private int age;
    private String company;
    private String address;

    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");


    public User(String name, int age, String company, String address) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name can not be empty");
        } else {
            this.name = name;
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age can not be less than 18");
        } else {
            this.age = age;
        }

        for (String job : VALID_JOBS) {
            if (!company.equalsIgnoreCase(job)) {
                throw new IllegalArgumentException("Invalid job");
            } else {
                this.company = company;
            }
        }

        if (!VALID_ADDRESS.contains(address)) {
            throw new IllegalArgumentException("Invalid address");
        } else {
            this.address = address;
        }


    }

    public int getAge() {
        return age;
    }

    private static Map<Integer, List<User>> groupUsers(List<User> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge));
    }
}
