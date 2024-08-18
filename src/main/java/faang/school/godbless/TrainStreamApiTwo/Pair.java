package faang.school.godbless.TrainStreamApiTwo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Pair<T> {
    T first;
    T second;

    public Pair reverse()
    {
        return new Pair<T>(second, first);
    }
}
