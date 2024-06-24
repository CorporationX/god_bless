package faang.school.godbless.Task22_API_2;

import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public static List<String> convertToBinary(List<Integer> integers) {
        return integers.stream().filter(x -> (x > -1 && x < 32))
                .map(Solver::toBinary)
                .collect(Collectors.toList());
    }

    public static List<Integer> findPalindrome(int a, int b) {
        return IntStream.rangeClosed(a, b).filter(x -> x > 0)
                .filter(Solver::ifPalindrome).boxed().collect(Collectors.toList());
    }

    public record Pair(int a, int b) {

        @Override
        public int hashCode() {
            return Objects.hash(a + b); //можно и по-другому, главное, один аргумент у hash
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (this.getClass() != o.getClass()) return false;
            Pair c = (Pair) o;
            return (c.a == this.a && c.b == this.b) || (c.b == this.a && c.a == this.b);
        }

    }

    public static String toBinary(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int k = number >> i;
            if ((k & 1) > 0) {
                result.append("1");
            } else result.append("0");
        }
        return result.toString();
    }

    public static boolean ifPalindrome(int k) {
        if (k < 10) return true;
        else {
            StringBuilder builder = new StringBuilder();
            String str = "" + k;
            for (int i = 0; i < str.length(); i++) {
                builder.append(str.charAt(i));
            }
            String string = builder.toString();
            String reverse = builder.reverse().toString();
            return string.equals(reverse);
        }
    }

}
