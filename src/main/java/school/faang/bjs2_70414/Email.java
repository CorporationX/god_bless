package school.faang.bjs2_70414;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;
}
