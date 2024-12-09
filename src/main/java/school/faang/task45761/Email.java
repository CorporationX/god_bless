package school.faang.task45761;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validate(subject, body);

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private void validate(String subject, String body) {
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Subject cannot be blank");
        }
        if (body == null || body.isBlank()) {
            throw new IllegalArgumentException("Body cannot be blank");
        }
    }


}
