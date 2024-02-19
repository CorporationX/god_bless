package faang.school.godbless.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
