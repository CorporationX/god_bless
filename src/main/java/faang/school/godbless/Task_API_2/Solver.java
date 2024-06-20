package faang.school.godbless.Task_API_2;

import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
public class Solver {

    public static Set<Pair> findPairs(List<Integer> numbers, int target) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        Set<Pair> result = new HashSet<>();
        numbers.forEach(x -> {
            if (numberSet.contains(target - x) && (target - x != x)) result.add(new Pair(x, target - x));
        });
        return result;
    }

    public record Pair(int a, int b) {

        @Override
        public int hashCode() {
            return Objects.hash(a + b); //зависимость от одной переменной
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.getClass() != o.getClass()) return false;
            Pair c = (Pair) o;
            return (c.a == this.a && c.b == this.b) || (c.b == this.a && c.a == this.b);
        }

    }

}
