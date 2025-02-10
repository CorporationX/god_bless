package school.faang.gmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {

    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;
}
