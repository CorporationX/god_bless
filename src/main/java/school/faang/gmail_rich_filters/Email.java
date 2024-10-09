package school.faang.gmail_rich_filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;
}