package faang.school.godbless.gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    String subject;
    String body;
    Boolean isImportant;
}
