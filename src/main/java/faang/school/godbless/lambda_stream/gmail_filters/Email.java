package faang.school.godbless.lambda_stream.gmail_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    String subject;
    String body;
    boolean isImportant;
}