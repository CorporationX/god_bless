package faang.school.godbless.module.second.lambda.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
