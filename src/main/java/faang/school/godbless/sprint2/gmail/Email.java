package faang.school.godbless.sprint2.gmail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

@Data
@AllArgsConstructor
@Value
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
