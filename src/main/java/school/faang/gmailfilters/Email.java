package school.faang.gmailfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Email {
    private final String subject;
    @Setter
    private String body;
    private final boolean isImportant;

}
