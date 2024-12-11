package school.faang.bjs245840;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;
}
