package faang.school.godbless.Task_Train_API_1;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.NoSuchElementException;

@NoArgsConstructor
public class Calculate {

    public static int findSum(List<Integer> numbers) {
        int res = numbers.stream()
                .reduce(0,(sum, number)->sum+number);
        return res;
    }

    public static int findMax(List<Integer> numbers) {
        int res = numbers.stream()
                .mapToInt(x->x)
                .max().orElseThrow(NoSuchElementException::new);
        return res;
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
