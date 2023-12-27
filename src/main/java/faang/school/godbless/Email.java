package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
