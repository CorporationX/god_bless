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
        Calculate.filterStrings(newNumbers, "ne");
        System.out.println();
        System.out.println(Calculate.sortByLength(newNumbers));

        System.out.println(Calculate.ifSuffice(numbers, x->x>0));
        System.out.println(Calculate.ifSuffice(numbers, x->x>2));

        System.out.println();
        System.out.println(Calculate.findMinWithCondition(numbers, x->x>1));
        System.out.println(Calculate.findMinWithCondition(numbers, x->x>5));


    }
}
