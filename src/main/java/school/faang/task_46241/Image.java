package school.faang.task_46241;

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
