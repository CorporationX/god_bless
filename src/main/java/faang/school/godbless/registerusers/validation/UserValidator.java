package faang.school.godbless.registerusers.validation;

import faang.school.godbless.registerusers.constants.UserConstants;

public class UserValidator {

    public static void validateParametersOfUser(final String name,
                                                final Integer age,
                                                final String company,
                                                final String address
    ) {
        boolean isValidName = validateName(name);
        boolean isValidAge = validateAge(age);
        boolean isValidCompany = validateCompany(company);
        boolean isValidAddress = validateAddress(address);
        checkIfValid(isValidName, "The name argument can not be blank or empty");
        checkIfValid(isValidAge, "The age argument should 18 or more");
        checkIfValid(isValidCompany, "The company argument should one of the followings " +
                "“Google”, “Uber”, “Amazon”");
        checkIfValid(isValidAddress, "The address argument should one of the followings " +
                "“London”, “New York”, “Amsterdam”");

    }

    private static boolean validateName(final String name) {
        return !name.isBlank();
    }

    private static boolean validateAge(final Integer age) {
        return age > 17;
    }

    private static boolean validateCompany(final String company) {
        return UserConstants.VALID_JOBS.contains(company);
    }

    private static boolean validateAddress(final String address) {
        return UserConstants.VALID_ADDRESSES.contains(address);
    }

    private static void checkIfValid(boolean isValid, String message) {
        if (!isValid) {
            throw new IllegalArgumentException(message);
        }
    }
}
