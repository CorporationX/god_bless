package Gmail_Rich_Filters;

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

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }

    public Email(String subject, String body, boolean isImportant){
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
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
