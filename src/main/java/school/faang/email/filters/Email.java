package school.faang.email.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Email {
    private final String subject;
    private String body;
    private final Boolean isImportant;
}
