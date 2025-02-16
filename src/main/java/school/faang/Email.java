package school.faang;

import lombok.Data;

public record Email(String subject, String body, Boolean isImportant) {

    public Email(String subject, String body, Boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
