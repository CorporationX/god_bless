package faang.school.godbless.bjs2_5014;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
