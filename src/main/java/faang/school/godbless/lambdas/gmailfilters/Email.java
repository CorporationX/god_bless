package faang.school.godbless.lambdas.gmailfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean important;
}
