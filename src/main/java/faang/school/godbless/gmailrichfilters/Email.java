package faang.school.godbless.gmailrichfilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    public String subject;
    public String body;
    public boolean isImportant; 
}
