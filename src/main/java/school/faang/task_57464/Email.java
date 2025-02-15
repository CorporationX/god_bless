package school.faang.task_57464;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Email {
    @NonNull
    private String subject;
    @NonNull
    private String body;
    private boolean isImportant;
}
