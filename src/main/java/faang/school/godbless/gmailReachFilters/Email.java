package faang.school.godbless.gmailReachFilters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Data
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
