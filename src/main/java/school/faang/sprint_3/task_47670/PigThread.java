package school.faang.sprint_3.task_47670;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class PigThread extends Thread {
    private final String pigName;
    private final String material;
}
