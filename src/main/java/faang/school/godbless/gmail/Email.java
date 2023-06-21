package faang.school.godbless.gmail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;

    public boolean isImportant() {
        return isImportant;
    }
}
