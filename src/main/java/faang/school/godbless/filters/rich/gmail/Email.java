package faang.school.godbless.filters.rich.gmail;

public class Email {
    public String subject;
    public String body;
    public boolean isImportant;

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

    @Override
    public String toString() {
        return "Email{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", isImportant=" + isImportant +
                '}';
    }
}
