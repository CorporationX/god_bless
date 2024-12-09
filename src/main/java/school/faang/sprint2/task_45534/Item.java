package school.faang.sprint2.task_45534;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Item {
    @NonNull
    private final String name;
    private final int value;
}
