package faang.school.godbless.TrainSteamAPI2;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;

@UtilityClass
public class StreamMethods {

    //Найдите все уникальные пары чисел, сумма которых равна заданному числу
    public void uniquePairs(List<Integer> numbers, int sum) {
        Set<List<Integer>> pair = numbers.stream()
                .peek(num -> num + numbers == sum).
    }

}
