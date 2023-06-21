package faang.school.godbless.google.filters;

public class Email {
    private final String subject;
    private final String body;
    private final boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public boolean isImportant() {
        return isImportant;
    }
}
