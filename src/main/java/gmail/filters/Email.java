package gmail.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;
}
