package school.faang.sprint2task45951;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;
}