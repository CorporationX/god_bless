package Sprint_2.BJS2_33723;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
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
