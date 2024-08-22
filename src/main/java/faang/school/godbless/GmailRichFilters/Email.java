package faang.school.godbless.GmailRichFilters;

import lombok.Data;

@Data
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty");
        }
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("Body cannot be null or empty");
        }

        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    @Override
    public String toString() {
        return "Subject: " + subject + " Body: " + body + " Important: " + isImportant;
    }
}
