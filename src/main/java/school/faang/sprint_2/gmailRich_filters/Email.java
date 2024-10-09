package school.faang.sprint_2.gmailRich_filters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
