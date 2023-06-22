package faang.school.godbless.gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        if (subject.isBlank()){
            throw new IllegalArgumentException("Subject is blank.");
        }
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
