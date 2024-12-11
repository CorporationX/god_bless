package school.faang.task_45830;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("subject не может быть пустым");
        }
        if (body == null || body.isEmpty()) {
            throw new IllegalArgumentException("body не может быть пустым");
        }
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
