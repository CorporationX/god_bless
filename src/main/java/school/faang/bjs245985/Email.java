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
        if (subject == null || subject.trim().isEmpty()) {
            logger.warn("Attempt to set an empty Subject line during Email object creation");
            throw new IllegalArgumentException("Subject of the letter cannot be empty");
        } else {
            this.subject = subject;
            logger.info("Email object created with Subject: {} ", subject);
        }

        if (body == null || body.trim().isEmpty()) {
            logger.warn("Attempt to set an empty letter's body during Email object creation");
            throw new IllegalArgumentException("Body of the letter cannot be empty");
        } else {
            this.body = body;
            logger.info("Email object created with Body: {} ", body);
        }

        this.isImportant = isImportant;
        logger.info("Importance flag has been set to: {} \n", isImportant);
    }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            logger.warn("Attempt to set an empty Subject line via setter");
            throw new IllegalArgumentException("Subject of the letter cannot be empty");
        } else {
            this.subject = subject;
            logger.info("Subject has been updated to: {}", getSubject());
        }
    }

    public void setBody(String body) {
        if (body == null || body.trim().isEmpty()) {
            logger.warn("Attempt to set an empty letter's body via setter");
            throw new IllegalArgumentException("Body of the letter cannot be empty");
        } else {
            this.body = body;
            logger.info("Body has been updated to: {}", getBody());
        }
    }

    public void setImportant(boolean important) {
        this.isImportant = important;
        if (logger.isInfoEnabled()) {
            logger.info("The letter is set as {}: {}", isImportant ? "important" : "not important", subject);
        }
    }
}