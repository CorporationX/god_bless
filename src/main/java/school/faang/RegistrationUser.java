package school.faang;

import lombok.ToString;

import java.util.List;
import java.util.Set;

@ToString
public class RegistrationUser {
    private static final int MIN_AGE = 18;
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESS = Set.of("London", "New York", "Amsterdam");

    private final String name;
    private final int age;
    private final String placeOfWork;
    private final String address;

    public RegistrationUser (String name, int age, String placeOfWork, String address) {
        if (!validUser (name, age, placeOfWork, address)) {
            throw new IllegalArgumentException("Недопустимые данные пользователя");
        } else {
            this.name = name;
            this.age = age;
            this.placeOfWork = placeOfWork;
            this.address = address;
        }

    }

    private boolean validUser (String name, int age, String placeOfWork, String address) {
        return name != null &&
                !name.isBlank() &&
                placeOfWork != null &&
                !placeOfWork.isBlank() &&
                address != null &&
                !address.isBlank() &&
                age >= MIN_AGE &&
                VALID_JOBS.contains(placeOfWork) &&
                VALID_ADDRESS.contains(address);
    }


    public static void main(String[] args) {
        RegistrationUser damba = new RegistrationUser("Damba", 37, "Google", "London");
        RegistrationUser kit = new RegistrationUser("Kit", 36, "Uber", "Amsterdam");
        RegistrationUser mongol = new RegistrationUser("Mongol", 36, "Amazon", "New York");

        List<RegistrationUser> userList = List.of(damba, kit, mongol);

        for (RegistrationUser user : userList) {
            System.out.println(user);
        }
    }

}

