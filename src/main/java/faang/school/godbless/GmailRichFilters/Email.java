package faang.school.godbless.GmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
