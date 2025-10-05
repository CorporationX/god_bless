package school.faang.sprint4.school;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Task {

    private final String name;
    private final Integer difficulty;
    private final Integer reward;
}
