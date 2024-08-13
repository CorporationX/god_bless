package faang.school.godbless.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;
}
