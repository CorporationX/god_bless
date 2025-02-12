package school.faang.naughtwoBJS257332;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        checkEmail(subject, body);
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private void checkEmail(String subject, String body) {
        if (subject == null || subject.isBlank()
                || body == null || body.isBlank()) {
            throw new IllegalArgumentException("Subject or Body is 'null'.");
        }
    }
}
