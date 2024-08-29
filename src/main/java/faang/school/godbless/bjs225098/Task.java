package faang.school.godbless.bjs225098;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Task {
    private final String name;
    private final int difficulty;
    private int reward;
}