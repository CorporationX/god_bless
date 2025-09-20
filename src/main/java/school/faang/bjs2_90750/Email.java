package school.faang.bjs2_90750;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Email {
    private final String subject;
    private final String body;
    private final boolean isImportant;
}