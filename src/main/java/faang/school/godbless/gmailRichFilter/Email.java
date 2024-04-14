package faang.school.godbless.gmailRichFilter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
