package school.faang.sprint2.task_45808;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    @NonNull
    private final String subject;
    @NonNull
    private String body;
    private final boolean isImportant;
}
