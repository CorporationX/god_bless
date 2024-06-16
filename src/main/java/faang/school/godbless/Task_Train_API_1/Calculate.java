package faang.school.godbless.Task_Train_API_1;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@NoArgsConstructor
public class Calculate {

    public static int findSum(List<Integer> numbers) {
        int res = numbers.stream()
                .reduce(0,(sum, number)->sum+number);
        return res;
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparingInt(x -> x)).orElseThrow(NoSuchElementException::new);
    }

    public static int findAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) throw new IllegalArgumentException("Empty List!");
        else {
            int res = numbers.stream()
                    .reduce(0, (sum, number) -> sum + number);
                    return res/numbers.size();
        }
    }


}
