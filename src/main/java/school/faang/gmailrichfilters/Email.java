package school.faang.gmailrichfilters;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Email {

    String subject;
    String body;
    boolean isImportant;

}
