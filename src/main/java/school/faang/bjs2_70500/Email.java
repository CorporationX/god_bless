package school.faang.bjs2_70500;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;
}
