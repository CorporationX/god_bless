package faang.school.godbless.gmail.rich.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;
}
