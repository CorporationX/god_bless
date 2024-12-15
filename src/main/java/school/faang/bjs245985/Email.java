package school.faang.bjs245985;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
public class Email {

    private static final Logger logger = LoggerFactory.getLogger(Email.class);

    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            logger.warn("Trying to set empty Subject line");
            throw new IllegalArgumentException("Subject of the letter cannot be empty");
        } else {
            this.subject = subject;
            logger.info("New Email Subject has been set: {}", getSubject());
        }
    }

    public void setBody(String body) {
        if (body == null || body.trim().isEmpty()) {
            logger.warn("Trying to set empty letter's body ");
            throw new IllegalArgumentException("Body of the letter cannot be empty");
        } else {
            this.body = body;
            logger.info("New Email Body has been set: {}", getBody());
        }
    }

    public void setImportant(boolean important) {
        this.isImportant = important;
        if (logger.isInfoEnabled()) {
            logger.info("The letter is set as {}: {}", isImportant ? "important" : "not important", subject);
        }
    }
}