package faang.school.godbless.BJS2_21440;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    boolean isImportant;
}
