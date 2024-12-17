package school.faang.task_47207;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class User {
    private final long id;
    @ToString.Exclude
    private final String name;
}
