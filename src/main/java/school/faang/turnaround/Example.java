package school.faang.turnaround;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        System.out.println(turnAround(list));

    }

    public static List<Integer> turnAround(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            result.add(numbers.get(i));
        }
        return result;
    }
}
