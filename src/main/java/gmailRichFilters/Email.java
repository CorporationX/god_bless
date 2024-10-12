package gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
