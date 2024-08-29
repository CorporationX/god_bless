package faang.school.godbless.fourthsprint.superheroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pair<T, U> {
    private final T first;
    private final U second;
}
