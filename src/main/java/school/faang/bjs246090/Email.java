package school.faang.bjs246090;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
