package faang.school.godbless.bjs2_18437;

import java.util.ArrayList;
import java.util.Set;

import static faang.school.godbless.bjs2_18437.Constants.AGE_OF_MAJORITY;
import static java.util.Optional.ofNullable;

public class UserValidator<T extends User> {
    private static final Set<String> VALID_JOBS = Set.of("Google", "Uber", "Amazon");
    private static final Set<String> VALID_ADDRESSES = Set.of("London", "New York", "Amsterdam");

    public void validateUserCreation(String name, int age, String jobPlace, String address) {
        var validated = validateStringField(name)
                && validateIntFieldMoreThanOrEquals(age, AGE_OF_MAJORITY)
                && validateStringFieldBelongsTo(jobPlace, VALID_JOBS)
                && validateStringFieldBelongsTo(address, VALID_ADDRESSES);
        if (!validated) {
            throw new IllegalArgumentException();
        }
    }

    public void validateUserCreationWithThrowingMessages(String name, int age, String jobPlace, String address) {
        var errors = new ArrayList<>();
        ofNullable(validateStringFieldWithReturnedMessage(name, "name")).ifPresent(errors::add);
        ofNullable(validateIntFieldMoreThanOrEqualsWithReturnedMessage(age, AGE_OF_MAJORITY, "age")).ifPresent(errors::add);
        ofNullable(validateStringFieldBelongsToWithReturnedMessage(jobPlace, VALID_JOBS, "job place")).ifPresent(errors::add);
        ofNullable(validateStringFieldBelongsToWithReturnedMessage(address, VALID_ADDRESSES, "address")).ifPresent(errors::add);

        if (!errors.isEmpty()) {
            var errorMessage = String.join(", ", errors.toArray(new String[0]));
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean validateStringField(String name) {
        if (AppStringUtils.isBlank(name)) {
            return false;
        }
        return true;
    }

    private String validateStringFieldWithReturnedMessage(String value, String fieldName) {
        if (AppStringUtils.isBlank(value)) {
            return "User " + fieldName + " cannot be null or blank.";
        }
        return null;
    }

    private boolean validateIntFieldMoreThanOrEquals(Integer value, int threshold) {
        if (value < threshold) {
            return false;
        }
        return true;
    }

    private String validateIntFieldMoreThanOrEqualsWithReturnedMessage(int value, int threshold, String fieldName) {
        if (value < threshold) {
            return "User " + fieldName + " should be more than " + threshold + ".";
        }
        return null;
    }

    private boolean validateStringFieldBelongsTo(String value, Set<String> array) {
        if (AppStringUtils.isBlank(value)) {
            return false;
        }

        if (!AppCollectionUtils.doesCollectionContainElement(array, value, true)) {
            return false;
        }

        return true;
    }

    private String validateStringFieldBelongsToWithReturnedMessage(String value, Set<String> array, String fieldName) {
        if (AppStringUtils.isBlank(value)) {
            return "User " + fieldName + " cannot be null or blank.";
        }

        if (!AppCollectionUtils.doesCollectionContainElement(array, value, true)) {
            return "User " + fieldName + ": '" + value + "' should be matched with one of allowed values.";
        }

        return null;
    }
}
