package school.faang.java8.lambda;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Email {
    @Setter
    private String subject;
    @Setter
    private String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

}