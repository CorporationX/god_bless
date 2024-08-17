package faang.school.godbless.BJS2_21342;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Email {
    private String subject;
    private String body;
    @Setter
    private boolean isImportant;
}
