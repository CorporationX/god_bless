package school.faang.bjs2_80033;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}

