package school.faang.task_57052;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
public class Student {
    @NonNull
    private String name;
}
