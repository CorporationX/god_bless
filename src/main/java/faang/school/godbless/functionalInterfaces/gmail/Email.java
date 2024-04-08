package faang.school.godbless.functionalInterfaces.gmail;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public String getImportance() {
        if (isImportant) {
            return "important";
        }

        return "yet another";
    }
}
