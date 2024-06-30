package faang.school.godbless.pave_the_way_with_your_finger;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class City {
    private final String name;
    private final Location cityLocation;
    private final int distance;
}
