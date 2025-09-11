package school.faang.gmail.rich.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Email {
    String subject;
    String body;
    boolean isImportant;
}
