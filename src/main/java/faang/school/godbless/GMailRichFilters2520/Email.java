package faang.school.godbless.GMailRichFilters2520;

import lombok.Data;

@Data
public class Email {

    private String subject;
    private String body;
    private boolean isImportant;

    public Email(String subject, String body, boolean isImportant) {
        this.subject = subject;
        this.body = body;
        this.isImportant = isImportant;
    }

    // fake method
    String translate(String text) {
        String translated = text; // magic happening *;&^%"}| boom
        return translated;
    }
}