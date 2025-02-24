package school.faang;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Robot {
    private final String name;
    private final int attackPower;
    private final int defencePower;
}
