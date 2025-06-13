package school.faang.gmailfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Email {

    private String subject;
    private String body;
    private boolean isImportant;

}
