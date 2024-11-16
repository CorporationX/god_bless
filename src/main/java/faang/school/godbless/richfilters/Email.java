package faang.school.godbless.richfilters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Email {
    private String body;
    private String subject;
    private Boolean isImportant;

    public Email(String body, String subject, Boolean isImportant) {
        this.body = body;
        this.subject = subject;
        this.isImportant = isImportant;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

    public Boolean isImportant() {
        return isImportant;
    }
}
