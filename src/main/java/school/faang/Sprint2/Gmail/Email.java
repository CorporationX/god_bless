package school.faang.Sprint2.Gmail;

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
