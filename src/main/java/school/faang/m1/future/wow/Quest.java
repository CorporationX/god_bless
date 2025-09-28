package school.faang.m1.future.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Quest {
    private final String name;
    private final int difficulty; // сложность = секунды выполнения
    private final int reward;
}
