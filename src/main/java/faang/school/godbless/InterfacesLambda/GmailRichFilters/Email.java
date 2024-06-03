package faang.school.godbless.InterfacesLambda.GmailRichFilters;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Email {
    private final String subject;
    private final String body ;
    private final boolean isImportant;

}
