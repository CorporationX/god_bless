package faang.school.godbless.streamapi_1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );

        System.out.println( sumOfEvenNumbers( numbers ) );
        System.out.println( findMax( numbers ) );
        System.out.println( "Average: " + getAverage( numbers ) );

        List<String> strings = List.of( "house", "dog", "pen", "pencil" );
        System.out.println( "Starts with 'p': " + countStringsStartingWithCharacter( strings, 'p' ) );


        List<String> strings2 = getStringsWithGivenSubstring( strings, "pen" );
        System.out.println( strings2 );
        strings2 = sortStringsByLength( strings );
        System.out.println(strings2);
        System.out.println( isConditionSatisfied( numbers, n -> n > 5 ) );
        System.out.println( findSmallestGreaterThan( numbers, 7 ) );
        System.out.println( convertStringsToLengths( strings ) );


    }

    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter( num -> num % 2 == 0 )
                .reduce( Integer::sum )
                .orElse( 0 );
    }

    public static int findMax(List<Integer> nums) {
        return nums.stream()
                .max( Integer::compareTo )
                .orElse( 0 );
    }

    public static double getAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt( Integer::valueOf )
                .average()
                .orElse( 0D );
    }

    public static long countStringsStartingWithCharacter(List<String> strings, char startChar) {
        return strings.stream()
                .filter( s -> s.startsWith( String.valueOf( startChar ) ) )
                .count();
    }

    public static List<String> getStringsWithGivenSubstring(List<String> strings, String s) {
        return strings.stream().filter( string -> string.contains( s ) ).collect( Collectors.toList() );
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream().sorted( Comparator.comparingInt( String::length ) ).collect( Collectors.toList() );
    }

    public static boolean isConditionSatisfied(List<Integer> nums, Predicate<Integer> condition) {
        return nums.stream().allMatch( condition );
    }

    public static int findSmallestGreaterThan(List<Integer> numbers, int target) {
        return numbers.stream().filter( n -> n > target ).min( Integer::compareTo ).orElse( 0 );
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream().map( String::length ).collect( Collectors.toList() );
    }
}
