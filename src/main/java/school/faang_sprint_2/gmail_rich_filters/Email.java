package school.faang_sprint_2.gmail_rich_filters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {

    private final String subject;
    private String body;
    private boolean isImportant;
}
