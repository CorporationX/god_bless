package school.faang.sprint2.gmailricherfilters;

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
