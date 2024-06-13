package faang.school.godbless.GmailRichFilters;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public boolean getIsImportant() {
        return this.isImportant;
    }
}
