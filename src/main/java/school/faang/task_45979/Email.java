package school.faang.task_45979;

import lombok.Data;

@Data
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;

    public Email(String subject, String body, Boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
