package school.faang.bjs274601;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Reward {
    SMALL(100),
    MEDIUM(500),
    BIG(1_000);

    private final int experience;
}
