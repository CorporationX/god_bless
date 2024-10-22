package school.BJS2_38402;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class Pair<F, S> {
    private final F first;
    private final S second;

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
