package school.faang.streamapithree;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Pair<U, V> {
    private final U o1;
    private final V o2;
}
