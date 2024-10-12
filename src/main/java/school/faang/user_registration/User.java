package school.faang.user_registration;

import lombok.Data;

import java.util.Set;

@Data
public class User {

    private static final Set<String> VALID_JOBS = Set.of("Amazon", "Google", "Uber");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");
    private static final int REQUIRED_MINIMUM_AGE = 18;

    private String name;
    private int age;
    private String workPlace;
    private String address;

    public User(String name, int age, String workPlace, String address) throws IllegalArgumentException {
        try {
            if (name.isBlank()) {
                throw new MyException(MyException.NAME_BLANK);
            } else if (age < REQUIRED_MINIMUM_AGE) {
                throw new MyException(MyException.INVALID_AGE);
            } else if (!VALID_JOBS.contains(workPlace)) {
                throw new MyException(MyException.INVALID_JOB);
            } else if (!VALID_ADDRESSES.contains(address)) {
                throw new MyException(MyException.INVALID_ADDRESS);
            } else {
                this.name = name;
                this.age = age;
                this.workPlace = workPlace;
                this.address = address;
            }
        } catch (MyException myException) {
            System.out.println("Please input correct credentials!");

        }

    }
}

