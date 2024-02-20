package faang.school.godbless.gmailRichFilters;

public class Email {
    String subject;
    String body;
    boolean isImportant;

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
