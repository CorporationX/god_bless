package faang.school.javacore.registrationuser;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ToString
public class User {
    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    private static int minAge = 18;

    private static Set<String> valid_jobs = Set.of("Google", "Uber", "Amazon");
    private static Set<String> valid_address = Set.of("London", "New York", "Amsterdam");

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
        if (name.isBlank()
                || age < this.minAge
                || !(valid_jobs.contains(placeOfWork))
                || !(valid_address.contains(address))) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        User alex = new User("Alex", 22, "Google", "Amsterdam");
        User oleg = new User("Oleg", 18, "Google", "Amsterdam");
        User max = new User("Max", 22, "Google", "Amsterdam");

        List<User> userList = new ArrayList<>(Arrays.asList(alex, oleg, max));

        for (User user : userList) {
            System.out.println(user);
        }
    }

}



