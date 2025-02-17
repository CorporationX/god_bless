package school.faang;

import java.util.List;

public class ListOperation {

    public static int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List isEmpty"));
    }


    public static double averageNubmers(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List isEmpty"));
    }


    public static int sumNumbers(


            public static int sumNumbers(


                    public static int sumNumbers(


                    public static int sumNumbers(


                    public static int sumNumbers(


                    public static int sumNumbers(

}
