package school.faang.sprint2.task_46286;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Image {
    @NonNull
    private final String name;
    @NonNull
    private final String description;
}
