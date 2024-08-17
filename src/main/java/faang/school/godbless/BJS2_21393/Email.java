package faang.school.godbless.BJS2_21393;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class Email {

    private String subject;
    private String body;
    private boolean isImportant;
}
