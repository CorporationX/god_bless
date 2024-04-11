package faang.school.godbless.streamAPI.streamAPI2;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        var nums = List.of(1, 9, 3, 6, 4, 5, 6,5);

        getPairsBySum(nums, 10).forEach(System.out::println);

        var first = new Pair(1, 9);
        var  second = new Pair(9,1);


        System.out.println("first: " + first);
        System.out.println("second: " + second);
        System.out.println(first.equals(second));

        nums.stream().distinct().forEach(System.out::println);
    }

    public static List<Pair> getPairsBySum(List<Integer> nums, int sum) {
        var stream = nums.stream()
                .map(num -> {
                    var secondHalfs = nums.stream()
                            .filter(currentNum -> !Objects.equals(currentNum, num))
                            .filter(currentNum -> currentNum + num == sum).toList();

                    return secondHalfs.stream().map(secondHalf -> new Pair(num, secondHalf)).findFirst();
                })
                .filter(Optional::isPresent)
                .map(Optional::get);

        var list = stream.toList();
        return list.stream().distinct().toList();
    }
}
