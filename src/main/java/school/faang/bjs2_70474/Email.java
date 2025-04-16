package school.faang.bjs2_70474;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private final String subject;
    private final boolean isImportant;
    private String body;
}