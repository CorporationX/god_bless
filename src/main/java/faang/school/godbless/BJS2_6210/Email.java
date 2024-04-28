package faang.school.godbless.BJS2_6210;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Email {
    @Setter private String subject;
    @Setter private String body;
    private boolean isImportant;
}
