package faang.school.godbless.gmailrichfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Email {
    private final String subject;
    private String body;
    private boolean isImportant;

}
