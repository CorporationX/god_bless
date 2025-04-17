package school.faang.sprinttwo.gmailrichfilters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    boolean isImportant;
}