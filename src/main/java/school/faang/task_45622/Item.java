package school.faang.task_45622;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class Item {
    private String name;
    @Setter
    private int value;
}
