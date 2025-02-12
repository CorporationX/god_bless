package school.faang.gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NonNull
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
