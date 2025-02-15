package school.faang;

import lombok.Data;

@Data
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, Boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;

    }
}
