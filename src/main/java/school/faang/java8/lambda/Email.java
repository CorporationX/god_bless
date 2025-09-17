package school.faang.java8.lambda;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Email {
    @Setter
    private String subject;
    @Setter
    private String body;
    private final boolean isImportant;
}