package school.faang.gmail;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Email {
    private final String subject;
    private final String body;
    private final boolean isImportant;
}
