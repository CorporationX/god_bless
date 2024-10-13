package school.faang.gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Setter
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;
}
