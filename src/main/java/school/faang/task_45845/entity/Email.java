package school.faang.task_45845.entity;

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
        if (subject == null || subject.isBlank() || body == null || body.isBlank()) {
            throw new NullPointerException("Subject or Body is null");
        }
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
