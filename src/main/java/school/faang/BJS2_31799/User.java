package school.faang.BJS2_31799;

import lombok.Data;
import java.util.Set;

@Data
public class User {

    protected static final Set<String> VALID_JOBS = Set.of("Amazon", "Google", "Uber");
    protected static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) {
        try {
            if (!name.isBlank() && age >= 18 && VALID_JOBS.contains(workPlace) && VALID_ADDRESSES.contains(address)) {
                this.name = name;
                this.age = age;
                this.workPlace = workPlace;
                this.address = address;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Data entered for the user is invalid. Please, try again!");
        }
    }
}
