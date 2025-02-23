package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Task {
    private final String name;
    private final int difficulty;
    private final int reward;
}
