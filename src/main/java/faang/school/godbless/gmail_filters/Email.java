package faang.school.godbless.gmail_filters;

import lombok.Getter;

@Getter
public class Email {

    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateArgument(subject, "Subject");
        validateArgument(body, "Body");

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private void validateArgument(String argument, String argumentType) {
        if (argument.isBlank()) {
            throw new IllegalArgumentException(argumentType + " can't be empty");
        }

        if (argument == null) {
            throw new IllegalArgumentException(argumentType + " can't be null");
        }
    }
}
