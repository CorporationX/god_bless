package school.faang.BJS2_33636_GmailRichFilters;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        validateString(subject, "Invalid email subject!");
        validateString(body, "Invalid email body!");
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    private void validateString(String info, String message) {
        if (info == null || info.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }
}
