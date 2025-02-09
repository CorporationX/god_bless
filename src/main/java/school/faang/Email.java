package school.faang;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateSubject(subject);
        validateBody(body);
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private void validateSubject(String subject) {
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("The subject can't be null or blank.");
        }
    }

    private void validateBody(String body) {
        if (body == null || body.isBlank()) {
            throw new IllegalArgumentException("The body can't be null or blank.");
        }
    }
}
