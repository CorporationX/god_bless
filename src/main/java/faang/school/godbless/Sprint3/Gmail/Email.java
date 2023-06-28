package faang.school.godbless.Sprint3.Gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;
}
