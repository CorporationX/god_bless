package school.faang.sprint2.bjs_45804;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {
    private final String subject;
    @Setter
    private String emailBody;
    public boolean isImportant;

    public Email(String subject, String emailBody, boolean isImportant) {
        this.subject = subject;
        this.emailBody = emailBody;
        this.isImportant = isImportant;
    }
}
