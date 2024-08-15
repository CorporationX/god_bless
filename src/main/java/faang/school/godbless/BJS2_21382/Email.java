package faang.school.godbless.BJS2_21382;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
