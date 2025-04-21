package school.faang.bjs2_70544;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {

    private final String subject;
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
