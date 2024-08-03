package faang.school.godbless.bjs2_18437;

import java.util.ArrayList;
import java.util.Set;

import static faang.school.godbless.bjs2_18437.Constants.AGE_OF_MAJORITY;
import static java.util.Optional.ofNullable;

public class UserValidator<T extends User> {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public void validateUserCreation(String name, Integer age, String jobPlace, String address) {
        var validated = validateName(name)
                && validateAge(age)
                && validateJobPlace(jobPlace)
                && validateAddress(address);
        if (!validated) {
            throw new IllegalArgumentException();
        }
    }

    public void validateUserCreationWithThrowingMessages(String name, Integer age, String jobPlace, String address) {
        var errors = new ArrayList<>();
        ofNullable(validateNameWithReturnedMessage(name)).ifPresent(errors::add);
        ofNullable(validateAgeWithWithReturnedMessage(age)).ifPresent(errors::add);
        ofNullable(validateJobPlaceWithReturnedMessage(jobPlace)).ifPresent(errors::add);
        ofNullable(validateAddressWithReturnedMessage(address)).ifPresent(errors::add);

        if (!errors.isEmpty()) {
            var errorMessage = String.join(", ", errors.toArray(new String[0]));
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean validateName(String name) {
        if (AppStringUtils.isBlank(name)) {
            return false;
        }
        return true;
    }

    private String validateNameWithReturnedMessage(String name) {
        if (AppStringUtils.isBlank(name)) {
            return "User name cannot be null or blank.";
        }
        return null;
    }

    private boolean validateAge(Integer age) {
        if (age == null || age < AGE_OF_MAJORITY) {
            return false;
        }
        return true;
    }

    private String validateAgeWithWithReturnedMessage(Integer age) {
        if (age == null || age < AGE_OF_MAJORITY) {
            return "User age cannot be null and should be more than " + AGE_OF_MAJORITY + ".";
        }
        return null;
    }

    private boolean validateJobPlace(String jobPlace) {
        if (AppStringUtils.isBlank(jobPlace)) {
            return false;
        }

        if (!AppCollectionUtils.isCollectionContainsElement(VALID_JOBS, jobPlace, true)) {
            return false;
        }

        return true;
    }

    private String validateJobPlaceWithReturnedMessage(String jobPlace) {
        if (AppStringUtils.isBlank(jobPlace)) {
            return "User job place cannot be null or blank.";
        }

        if (!AppCollectionUtils.isCollectionContainsElement(VALID_JOBS, jobPlace, true)) {
            return "User job place should be matched with one of allowed companies.";
        }

        return null;
    }

    private boolean validateAddress(String address) {
        if (AppStringUtils.isBlank(address)) {
            return false;
        }

        if (!AppCollectionUtils.isCollectionContainsElement(VALID_ADDRESSES, address, true)) {
            return false;
        }

        return true;
    }

    private String validateAddressWithReturnedMessage(String address) {
        if (AppStringUtils.isBlank(address)) {
            return "User job place cannot be null or blank.";
        }

        if (!AppCollectionUtils.isCollectionContainsElement(VALID_ADDRESSES, address, true)) {
            return "User job place should be matched with one of allowed cities.";
        }

        return null;
    }
}
