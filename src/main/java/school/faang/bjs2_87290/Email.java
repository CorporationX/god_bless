package school.faang.bjs2_87290;

import lombok.Getter;
import lombok.Setter;

public class Email {
    @Getter
    private String subject;
    @Getter
    @Setter
    private String body;
    @Getter
    boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
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
