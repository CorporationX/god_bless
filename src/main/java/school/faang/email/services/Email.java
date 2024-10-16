package school.faang.email.services;

import lombok.Data;

@Data
public class Email {
    private String subject;
    private String body;
    private boolean isImpotant;

    public Email(String subject, String body, boolean isImpotant) {
        this.subject = subject;
        this.body = body;
        this.isImpotant = isImpotant;
    }
}
