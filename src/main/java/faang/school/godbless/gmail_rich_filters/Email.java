package faang.school.godbless.gmail_rich_filters;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        if (subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be empty");
        }
        if (body.isEmpty()) {
            throw new IllegalArgumentException("Body cannot be empty");
        }
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
