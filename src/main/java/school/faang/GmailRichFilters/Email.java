package school.faang.GmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Struct;

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
