package faang.school.godbless.lambda.task11_GmailRishFilters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    boolean isImportant;
}
