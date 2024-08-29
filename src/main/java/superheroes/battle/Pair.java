package superheroes.battle;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class Pair<U, V> {
    private final U first;
    private final V second;

    public Pair(@NonNull U first, @NonNull V second) {
        this.first = first;
        this.second = second;
    }
}
