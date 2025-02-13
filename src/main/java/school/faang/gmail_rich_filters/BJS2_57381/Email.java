package school.faang.gmail_rich_filters.BJS2_57381;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
public class Email {
    private static final Logger LOGGER = LoggerFactory.getLogger(Email.class);

    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateString(subject, "subject is blank");
        validateString(body, "body is blank");

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private static void validateString(String subject, String message) {
        if (subject == null || subject.isBlank()) {
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
    }
}
