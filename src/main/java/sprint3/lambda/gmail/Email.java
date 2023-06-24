package sprint3.lambda.gmail;

import lombok.Data;

@Data
public class Email {
    private final String subject;
    private final String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
