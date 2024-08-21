package faang.school.godbless.task.multithreading.might.and.magic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Character {
    private final String type;
    private final String name;
    private final int power;
}
