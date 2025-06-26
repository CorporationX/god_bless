package school.faang.filters;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private Boolean isImportant;
}
