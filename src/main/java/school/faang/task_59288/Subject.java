package school.faang.task_59288;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Subject {
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
