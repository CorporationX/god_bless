package school.faang.bjs270450;

import lombok.Data;

@Data
public class Email {
    private final String subject;
    private final String body;
    public final boolean isImportant;
}