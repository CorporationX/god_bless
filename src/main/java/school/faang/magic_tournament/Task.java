package school.faang.magic_tournament;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Task {
    private final String name;
    private final int difficulty;
    @Getter
    private final int reward;
}
