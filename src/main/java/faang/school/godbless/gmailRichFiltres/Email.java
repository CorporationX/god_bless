package faang.school.godbless.gmailRichFiltres;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Email {
    String subject;
    String body;
    boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
