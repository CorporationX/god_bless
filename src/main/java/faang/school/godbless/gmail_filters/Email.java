package faang.school.godbless.gmail_filters;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Email {

    private final String subject;
    private final String body;
    private final boolean isImportant;
}
