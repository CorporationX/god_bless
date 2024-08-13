package gmail.filters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private final String subject;
    private final String body;
    private boolean isImportant;
}
