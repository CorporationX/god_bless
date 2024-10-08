package school.faang.gmailrichfilter.maincode;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;
}
