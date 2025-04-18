package school.faang.bjs270509;

public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

}
