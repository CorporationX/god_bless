package school.faang.task_57586;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Item {
    @NonNull
    private String name;
    private int value;
}
