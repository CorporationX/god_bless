import lombok.NonNull;

import java.util.Set;

public class User {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(@NonNull String name, int age, String workPlace, String address) {

        if (!(age < 18)) {
            this.age = age;
        } else if (VALID_JOBS.contains(workPlace)) {
            this.workPlace = workPlace;
        } else if (VALID_ADDRESSES.contains(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }


}


