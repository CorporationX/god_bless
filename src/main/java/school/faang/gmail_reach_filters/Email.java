package school.faang.gmail_reach_filters;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
