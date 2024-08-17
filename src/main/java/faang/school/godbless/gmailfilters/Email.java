package faang.school.godbless.gmailfilters;

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