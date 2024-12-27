package gmail_rich_filters;

import lombok.Data;

@Data
public class Email {
    private String subject;
    private String body;
    private boolean important;

    public Email(String subject, String body, boolean important) {
        this.subject = subject;
        this.body = body;
        this.important = important;
    }
}