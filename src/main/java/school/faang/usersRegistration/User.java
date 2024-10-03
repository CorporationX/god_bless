package school.faang.usersRegistration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public record User(
        String name,
        String age,
        String workPlace,
        String address
) {
    public static Set<String> VALID_JOBS = new HashSet<>(Arrays.asList("Google", "Uber", "Amazon"));
    public static Set<String> VALID_ADDRESSES = new HashSet<>(Arrays.asList("London", "New York", "Amsterdam"));

    public User(String name, String age, String workPlace, String address) {
        if(name == null || name.equals("")) {
            throw new IllegalArgumentException("name is null or empty");
        }
        if(Integer.parseInt(age) < 18) {
            throw new IllegalArgumentException("age can`t be less then 18");
        }
        if(!VALID_JOBS.contains(workPlace)) {
            throw new IllegalArgumentException("workPlace can be only \"Google\", \"Uber\" or \"Amazon\"");
        }
        if(!VALID_ADDRESSES.contains(address)) {
            throw new IllegalArgumentException("address can be only \"London\", \"New York\" or \"Amsterdam\"");
        }

        this.name = name;
        this.age = age;
        this.workPlace = workPlace;
        this.address = address;
    }
}
