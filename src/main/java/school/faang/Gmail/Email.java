package school.faang.Gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;
}
