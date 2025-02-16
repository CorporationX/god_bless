package school.faang.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;
}
