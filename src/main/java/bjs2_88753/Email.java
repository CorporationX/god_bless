package bjs2_88753;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

}