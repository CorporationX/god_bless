package school.faang.gmail_rich_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;

    public boolean isImportant() {
        return this.isImportant;
    }
}
