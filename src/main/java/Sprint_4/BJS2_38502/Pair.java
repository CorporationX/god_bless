package Sprint_4.BJS2_38502;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }
}
