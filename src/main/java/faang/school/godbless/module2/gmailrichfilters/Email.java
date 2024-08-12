package faang.school.godbless.module2.gmailrichfilters;

import lombok.*;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
