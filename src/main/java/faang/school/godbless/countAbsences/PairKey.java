package faang.school.godbless.countAbsences;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PairKey<F, S> {
    private final F first;
    private final S second;


    public PairKey(F first, S second) {
        this.first = first;
        this.second = second;
    }
}