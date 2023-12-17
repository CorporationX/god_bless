package faang.school.godbless.Gmail_Rich_Filters;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Email {
    private String subject;
    private String body;
    private boolean isImportant;


}
