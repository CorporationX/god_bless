package school.faang.bjs270450;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}