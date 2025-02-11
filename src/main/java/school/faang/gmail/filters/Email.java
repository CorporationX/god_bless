package school.faang.gmail.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private final String subject;
    private String body;
    private boolean isImportant;
}
