package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {
    private static final int MIN_SUBJECT_LENGTH = 3;
    private static final int MAX_SUBJECT_LENGTH = 100;
    private static final int MIN_BODY_LENGTH = 5;
    private static final int MAX_BODY_LENGTH = 1000;

    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateString(subject, "Subject", MIN_SUBJECT_LENGTH, MAX_SUBJECT_LENGTH);
        validateString(body, "Body", MIN_BODY_LENGTH, MAX_BODY_LENGTH);
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private void validateString(String value, String fieldName, int minLength, int maxLength) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " can't be null or blank. Provided value: " + value);
        }
        if (value.length() < minLength || value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " must be between " + minLength +
                    " and " + maxLength + " characters long.");
        }
    }
}
