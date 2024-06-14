package faang.school.godbless.GmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;
}
