package faang.school.godbless.Task_Train_API_1;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(Calculate.findSum(numbers));
        Calculate.findMax(numbers);
        Calculate.findAvg(numbers);

        List<String> newNumbers = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
        System.out.println("We found " + Calculate.findStrings(newNumbers, 's') + " word(s)");

    }
}
