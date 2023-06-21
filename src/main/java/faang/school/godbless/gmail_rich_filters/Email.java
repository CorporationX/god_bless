package faang.school.godbless.gmail_rich_filters;

public class Email {
    private final String subject;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
