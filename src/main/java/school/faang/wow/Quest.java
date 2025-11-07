package school.faang.wow;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Quest {
    private final String name;
    private final int difficulty;
    private final int reward;
}
