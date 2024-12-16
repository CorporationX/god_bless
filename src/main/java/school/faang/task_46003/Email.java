package school.faang.task_46003;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {
    private String subject;
    @Setter private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        if (subject.trim().isEmpty() || body.trim().isEmpty()) {
            throw new IllegalArgumentException("All field must be filled");
        }
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
