package faang.school.godbless.Sprint3.Task_6_Gmail;

public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }
}
