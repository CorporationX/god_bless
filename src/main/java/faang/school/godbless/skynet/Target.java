package faang.school.godbless.skynet;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Target {
    private final String name;
    private boolean isAlive = true;
}
