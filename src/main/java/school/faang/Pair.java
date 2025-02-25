package school.faang;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Pair<T, U> {
    private final T first;
    private final U second;
}
