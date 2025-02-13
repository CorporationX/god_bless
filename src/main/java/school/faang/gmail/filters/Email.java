package school.faang.gmail.filters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private final String subject;
    private String body;
    private final boolean isImportant;

    @Override
    public String toString() {
        return "Тема: " + subject + ", Тело письма: " + body;
    }
}
