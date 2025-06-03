package school.faang.user_registration.utility;

public class Validator {

    public static boolean validateStringForNotNullAndNotEmpty(String string) {
        return string != null && !string.isEmpty();
    }

}
