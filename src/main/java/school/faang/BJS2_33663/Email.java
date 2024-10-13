package school.faang.BJS2_33663;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
