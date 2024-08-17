package faang.school.godbless.gmailrichfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;
}