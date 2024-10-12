package school.faang.streamApi_1;

import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers (List<Integer> numbers){
       return numbers.stream().reduce(0,(acc,elem)-> acc+=elem);
    }
    public static int findMax (List<Integer> numbers){
        return  numbers.stream().mapToInt(Integer::intValue).max().orElse(Integer.MAX_VALUE);
    }

    public static int findAverage (List<Integer> numbers){
        return  (int) numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static int countStringsStartingWith (List<String> stringList, Character character){
        return (int) stringList.stream().filter(e->e.charAt(0) == character).count();
    }

    public static int filterStringsContainingSubstring (List<String> stringList, String character){
        return (int) stringList.stream().filter(e->e.contains(character)).count();
    }

    public static List<String> sortByLength (List<String> stringList){
        return stringList.stream().sorted((a,b)-> a.length()-b.length()).toList();
    }

    public static <T> boolean allMatchCondition(List<T> list, Predicate<T> condition) {
        return list.stream().allMatch(condition);
    }

    public static int findMinGreaterThan (List<Integer> numbers, int number){
        return numbers.stream().filter(e->e>number).min(Integer::compareTo).orElse(null);
    }

    public static List<Integer> convertToLengths (List<String> stringList ){
       return stringList.stream().map(e-> e.length()).toList();
    }
}
