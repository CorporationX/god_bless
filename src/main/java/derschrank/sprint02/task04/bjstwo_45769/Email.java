package derschrank.sprint02.task04.bjstwo_45769;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    @Override
    public String toString() {
        return "Subject: " + subject + ". " + (isImportant ? "IMPORTANT!" : "Not important.") + "\nBody: " + body;
    }
}
