package faang.school.godbless.gmail_filters;

import lombok.Getter;

@Getter
public class Email {

    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateArgument(subject);
        validateArgument(body);

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public void setBody(String body) {
        validateArgument(body);

        this.body = body;
    }

    private void validateArgument(String argument) {
        if (argument.isBlank()) {
            throw new IllegalArgumentException("Argument can't be empty");
        }

        if (argument == null) {
            throw new IllegalArgumentException("Argument can't be null");
        }
    }
}
