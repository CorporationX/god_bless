package school.faang.bjs_45873;

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
    private final boolean isImportant;
    @Setter
    private String body;
}
