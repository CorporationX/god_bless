package faang.school.godbless.sprint_3.gmail_rich_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    private String body;
    boolean isImportant;

}
