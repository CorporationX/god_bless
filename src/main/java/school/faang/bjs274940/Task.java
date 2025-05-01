package school.faang.bjs274940;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Task {
    private final String name;
    private final Difficulty difficulty;
    private final int reward;
}
