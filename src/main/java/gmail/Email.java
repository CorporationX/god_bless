package gmail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
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

    public boolean getIsimportan() {
        return isImportant;
    }

    public void setIsimportan(boolean isImportant) {
        this.isImportant = isImportant;
    }

    @Override
    public String toString() {
        return "Email{"
                + "subject='" + subject + '\''
                + ", body='" + body + '\''
                + ", isImportant=" + isImportant
                + '}';
    }
}
