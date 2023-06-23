package faang.school.godbless.sprint2.trainStreamAPI;

import java.util.List;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(sumOfEvenNumbers(ints));
        System.out.println(maxIntInList(ints));

    }

    public static int sumOfEvenNumbers(List<Integer> ints){
        return ints.stream().filter(value -> value % 2 == 0).reduce(Integer::sum).get();
    }
    public static OptionalInt maxIntInList(List<Integer> ints){
        return ints.stream().mapToInt(Integer::intValue).max();
    }

}
