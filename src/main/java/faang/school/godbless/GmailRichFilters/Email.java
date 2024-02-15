package faang.school.godbless.GmailRichFilters;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    public String subject;
    public String body;
    public boolean isImportant;

    public Email(String subject, String body, boolean isImportant){
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
