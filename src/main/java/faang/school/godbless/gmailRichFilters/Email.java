package faang.school.godbless.gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@Value
@AllArgsConstructor
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
