package school.faang.gmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Email {
    @NonNull private String subject;
    @NonNull private String body;
    private boolean isImportant;
}
