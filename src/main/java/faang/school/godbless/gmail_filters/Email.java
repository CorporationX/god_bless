package faang.school.godbless.gmail_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
