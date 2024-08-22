package faang.school.godbless.BJS221345;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
