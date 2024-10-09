package school.faang.gmailFilter;

import lombok.Data;

@Data
public class Email {
    private final String subject;
    private final String body;
    private final boolean isImportant;
}
