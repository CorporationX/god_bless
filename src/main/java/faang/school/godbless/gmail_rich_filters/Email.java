package faang.school.godbless.gmail_rich_filters;

import lombok.Setter;

@Setter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public String getSubject() {
        return subject;
    }
    public String getBody() {
        return body;
    }
    public boolean getIsImportant() {
        return isImportant;
    }
}
