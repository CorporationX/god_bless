package faang.school.godbless.gmailRFilters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateParameter(subject, "subject");
        validateParameter(body, "body");

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private <T> void validateParameter(T parameter, String parameterName) {
        if (parameter == null) {
            throw new IllegalArgumentException(parameterName + " can't be blank");
        }
    }
}
