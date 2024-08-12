package faang.school.javacore.registrationuser;

import lombok.ToString;

import java.util.List;
import java.util.Set;

@ToString
public class User {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public User(String name, int age, String placeOfWork, String address) {
        if (validUser(name, age, placeOfWork, address)) {
            throw new IllegalArgumentException();
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }

    }

    private boolean validUser(String name, int age, String placeOfWork, String address) {
        return name == null
                || placeOfWork == null
                || address == null
                || name.isBlank()
                || placeOfWork.isBlank()
                || address.isBlank()
                || age < MIN_AGE
                || !(VALID_JOBS.contains(placeOfWork))
                || !(VALID_ADDRESS.contains(address));
    }


    public static void main(String[] args) {
        User alex = new User("Alex", 22, "Google", "Amsterdam");
        User oleg = new User("Oleg", 18, "Google", "Amsterdam");
        User max = new User("Max", 22, "Google", "Amsterdam");

        List<User> userList = List.of(alex, oleg, max);

        for (User user : userList) {
            System.out.println(user);
        }
    }

}



