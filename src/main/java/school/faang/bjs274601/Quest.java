package school.faang.bjs274601;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Quest {
    private final String name;
    private final Difficult difficult;
    private final Reward reward;
}
