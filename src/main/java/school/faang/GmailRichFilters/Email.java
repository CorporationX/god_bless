package school.faang.GmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public void setBody(String newBody) {
        this.body = newBody;
    }
}
