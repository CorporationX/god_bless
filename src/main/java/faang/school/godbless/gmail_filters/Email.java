package faang.school.godbless.gmail_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    String subject;
    String body;
    boolean isImportant;
}