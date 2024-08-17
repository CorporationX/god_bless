package faang.school.godbless.task.hashmap.elk.query.index;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class User {
    private final Long id;
    private final String name;
}
