package faang.school.godbless.sprint3.task13;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Email {

    private String subject;

    private String body;

    private boolean isImportant;
}
