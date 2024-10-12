package StreamApi1;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ListOperation listOperation = new ListOperation();
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7);
        List<String> stringList = List.of("Olyaaa", "Kolyaaaa", "Tolya");
        System.out.println("Sum of even numbers in a list: " + listOperation.sum(nums));
        System.out.println("Maximum element of the list: " + listOperation.max(nums));
        System.out.println("Maximum element of the list: " + listOperation.findMax(nums));
        System.out.println("Count string  start with char : " + listOperation.countStringWithChar(stringList, 'K'));
        System.out.println("String  contains substring: " + listOperation.countStringWitFragment(stringList, "ly"));
        System.out.println("String  sorted by lenth: " + listOperation.sortByLenth(stringList));
        System.out.println("Numbers >3: " + listOperation.allMatchCondition(nums, n -> n > 3));
        System.out.println("Elements greater than " + listOperation.minForSublist(nums,4));
        System.out.println("Lenth strings: " + listOperation.mapToLengths(stringList));


    }
}
