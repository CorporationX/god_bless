package faang.school.godbless.registration_user;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter

public class Main {

        private static final Set<String> VALID_JOBS = new HashSet<>();

        static {
            VALID_JOBS.add("Google");
            VALID_JOBS.add("Uber");
            VALID_JOBS.add("Amazon");
        }

        private static final Set<String> VALID_ADDRESSES = new HashSet<>();

        static {
            VALID_ADDRESSES.add("London");
            VALID_ADDRESSES.add("New York");
            VALID_ADDRESSES.add("Amsterdam");
        }
    public RegistrationUser(String firstname, int age, String placeofwork, String adds) {

        if (firstname == null || firstname.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (age < 18) {
            throw new IllegalArgumentException("Age cannot be less than 18");
        }

        if (!VALID_JOBS.contains(placeofwork)) {
            throw new IllegalArgumentException("Invalid place of work");
        }

        if (!VALID_ADDRESSES.contains(adds)) {
            throw new IllegalArgumentException("Invalid addresses");
        }

        this.firstname = firstname;
        this.age = age;
        this.placeofwork = placeofwork;
        this.adds = adds;
    }
}
