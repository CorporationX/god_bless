package school.faangSprint2.t4;

import lombok.Getter;
import lombok.Setter;

@Getter
class Email {
    private String subject;
    @Setter
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public boolean isImportant() {
        return isImportant;
    }
}