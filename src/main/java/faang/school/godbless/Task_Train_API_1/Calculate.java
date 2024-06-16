package faang.school.godbless.Task_Train_API_1;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
public class Calculate {

    //private static final List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

    public static int findSum(List<Integer> numbers) {
        int res = numbers.stream()
                .reduce(0,(sum, number)->sum+number);
        return res;
    }

}
