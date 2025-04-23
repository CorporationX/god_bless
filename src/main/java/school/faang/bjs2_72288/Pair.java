package school.faang.bjs2_72288;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@AllArgsConstructor
@ToString
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
        return (Objects.equals(this.firstValue, other.firstValue)
                && Objects.equals(this.secondValue, other.secondValue))
                || Objects.equals(this.firstValue, other.secondValue)
                && Objects.equals(this.secondValue, other.firstValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue) + Objects.hash(secondValue);
    }
}
