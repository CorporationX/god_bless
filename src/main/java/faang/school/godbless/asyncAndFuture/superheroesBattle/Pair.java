package faang.school.godbless.asyncAndFuture.superheroesBattle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pair<T1, T2> {
    private T1 first;
    private T2 second;
}
