package faang.school.godbless.gmail;

import lombok.Getter;

@Getter
public class Email {
    private String subject, body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.body = body;
        this.subject = subject;
        this.isImportant = isImportant;
    }
}
