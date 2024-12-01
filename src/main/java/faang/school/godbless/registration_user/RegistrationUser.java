package faang.school.godbless.registration_user;

import java.util.ArrayList;
import java.util.List;


public class RegistrationUser {
    private String firstname;
    private int age;
    private String placeOfWork;
    private String adds;

    public RegistrationUser(String firstname, int age, String placeOfWork, String adds) {
        this.firstname = isValidFirstName(firstname);
        this.age = isValidAge(age);
        this.placeOfWork = isValidPlaceOfWork(placeOfWork);
        this.adds = isValidAddress(adds);
    }

    private static int isValidAge(int age) {
        if (age > 18) {
            return age;
        } else {
            throw new IllegalArgumentException("Age cannot be less 18");
        }
    }

    private static String isValidPlaceOfWork(String placeOfWork) {
        List<String> works = new ArrayList<>();
        works.add("Google");
        works.add("Uber");
        works.add("Amazon");
        String value = "";

        for (String work : works) {
            if (work.contains(placeOfWork)) {
                value = work;
                break;
            } else {
                throw new IllegalArgumentException("Invalid place of work");
            }
        }

        return value;
    }

    private static String isValidAddress(String adds) {
        List<String> address = new ArrayList<>();
        address.add("London");
        address.add("New York");
        address.add("Amsterdam");
        String valueadds = "";

        for (String homeaddress : address) {
            if (address.contains(adds)) {
                valueadds = homeaddress;
                return adds;
            } else {
                throw new IllegalArgumentException("Invalid addresses");
            }
        }
        return valueadds;
    }

    private static String isValidFirstName(String firstname) {
        if (firstname == null) {
            return firstname;
        } else {
            throw new IllegalArgumentException("Firstname cannot be null");
        }
    }
}


