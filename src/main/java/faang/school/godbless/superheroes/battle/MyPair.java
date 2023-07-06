package faang.school.godbless.superheroes.battle;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class MyPair<L,R> {
    private final L first;
    private final R second;
}
