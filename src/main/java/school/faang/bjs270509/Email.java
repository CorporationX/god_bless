package school.faang.bjs270509;

import lombok.Getter;
import lombok.Setter;

public class Email {
    @Getter
    private String subject;
    @Getter
    @Setter
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public boolean isImportant() {
        return isImportant;
    }

}
