package school.faang.bjs2_70828;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class Pair<T> {
    private final T firstValue;
    private final T secondValue;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair<?> other)) {
            return false;
        }

        return (Objects.equals(firstValue, other.firstValue) && Objects.equals(secondValue, other.secondValue))
                || (Objects.equals(firstValue, other.secondValue) && Objects.equals(secondValue, other.firstValue));
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue) + Objects.hash(secondValue);
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", firstValue, secondValue);
    }
}