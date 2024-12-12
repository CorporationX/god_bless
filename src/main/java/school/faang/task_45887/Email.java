package school.faang.task_45887;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateSubject(subject);
        validateBody(body);

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private static void validateBody(String body) {
        if (body == null || body.isBlank()) {
            throw new IllegalArgumentException("Body don't be null or blank!");
        }
    }

    private static void validateSubject(String subject) {
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Subject don't be null or blank!");
        }
    }
}
