package school.faang.sprint2.task_bjs245902;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Email {
    private String subject;
    @Setter
    private String body;
    private boolean isImportant;
}
