package school.faang.helpanimal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class Donation {
    private static int currentId = 1;

    private final int id = currentId++;
    private final int amount;
}
