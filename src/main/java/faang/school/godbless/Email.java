package faang.school.godbless;

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
        return this.subject;
    }

    public String getBody() {
        return this.subject;
    }

    public boolean isImportant() {
        return this.isImportant;
    }
}
