package faang.school.godbless.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
