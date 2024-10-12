package school.faang.sream_api2;

import java.util.List;

public class TreinClass {


    public static List<List<Integer>> getPairNumber(List<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(numberFirst -> numbers.stream()
                        .filter(numberSecond -> numberFirst + numberSecond == target)
                        .map(numberSecond -> List.of(numberFirst, numberSecond).stream().sorted().toList()))
                .toList().stream().distinct().toList();
    }

}
