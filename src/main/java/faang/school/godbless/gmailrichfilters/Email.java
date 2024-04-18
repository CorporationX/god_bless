package faang.school.godbless.gmailrichfilters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Email {
    private final String subject;
    private final String body;
    private boolean isImportant;
}
