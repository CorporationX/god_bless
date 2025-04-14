package school.faang.bjs2_70414;

import lombok.Getter;
import lombok.Setter;

public class Email {
    @Getter
    private final String subject;
    @Setter
    @Getter
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
