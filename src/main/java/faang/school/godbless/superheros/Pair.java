package faang.school.godbless.superheros;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Pair<F, S> {
    private F firstElement;
    private S secondElement;
}
