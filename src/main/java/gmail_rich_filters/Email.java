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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }
}