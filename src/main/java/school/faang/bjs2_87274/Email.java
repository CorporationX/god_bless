package school.faang.bjs2_87274;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        if ((subject == null || subject.isBlank())
                || (body == null || body.isBlank())) {
            throw new IllegalArgumentException("Письмо должно иметь тему и содержание!");
        }
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}