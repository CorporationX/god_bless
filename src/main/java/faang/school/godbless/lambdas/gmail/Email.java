package faang.school.godbless.lambdas.gmail;

import lombok.Data;

@Data
public class Email {
    private String subject;
    private String body;
    boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        if (subject == null || subject.isEmpty() || subject.isBlank()) {
            throw new IllegalArgumentException("Subject can`t be empty");
        }
        if (body == null || body.isEmpty() || body.isBlank()) {
            throw new IllegalArgumentException("Body can`t be empty");
        }
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
