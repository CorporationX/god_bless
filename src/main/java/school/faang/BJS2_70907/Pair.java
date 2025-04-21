package school.faang.BJS2_70907;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@AllArgsConstructor
public class Pair<T> {
    private T key;
    private T value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?> pair = (Pair<?>) o;
        return (Objects.equals(key, pair.key) && Objects.equals(value, pair.value))
                || (Objects.equals(key, pair.value) && Objects.equals(value, pair.key));
    }

    @Override
    public int hashCode() {
        return Objects.hash(key) + Objects.hash(value);
    }
}
