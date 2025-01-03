package derschrank.sprint04.task10.bjstwo_50592;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@RequiredArgsConstructor
public class PairToFight<T> {
    private final T left;
    private final T right;
    @Setter
    private Optional<T> winner;
}
