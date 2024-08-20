package faang.school.godbless.sprint2.BJS2_21363;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}