package school.faang.bjs245927;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
