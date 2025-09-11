package school.faang.bjs2_87310;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
