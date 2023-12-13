package faang.school.godbless.gmailRishFilter;

public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }
}
