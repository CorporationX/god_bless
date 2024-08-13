package faang.school.godbless.javalambda.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
