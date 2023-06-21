package faang.school.godbless.gmailRichFilters;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
