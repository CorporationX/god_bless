package school.faang.BJS2_71872;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}