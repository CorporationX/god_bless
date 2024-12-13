package school.faang.sprint_1.task_gmailrichfiltersbjs2n45878;

import lombok.Getter;

@Getter
public class Email {
    private static final String DEFAULT_SUBJECT = "Без темы";
    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) throws InvalidInputException {
        if (paramsAreCorrect(subject, body)) {
            if (subject.trim().isEmpty()) {
                this.subject = DEFAULT_SUBJECT;
            } else {
                this.subject = subject;
            }
            this.body = body;
            this.isImportant = isImportant;
        } else {
            throw new InvalidInputException("invalid parameters of the email.");
        }
    }

    public void setBody(String body) {
        this.body = body;
    }

    private boolean paramsAreCorrect(String subject, String body) {
        return (subject != null
                && body != null);
    }
}
