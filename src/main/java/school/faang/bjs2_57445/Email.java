package school.faang.bjs2_57445;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
