package school.faang.sprint_2.gmail_rich_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
