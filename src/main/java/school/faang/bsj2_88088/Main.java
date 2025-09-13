package school.faang.bsj2_88088;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MethodsWithStreams methodsWithStreams = new MethodsWithStreams();

        Set<Integer> numbers = Set.of(1, 4, 7, 9, 11, 13, 15, 2, 5, 8, 10, 12, 14);
        System.out.println(methodsWithStreams.getCoupleOfInteger(numbers, 20));


        Map<String, String> countriesAndCapitals = Map.of("USA", "Washington", "Russia", "Moscow", "China", "Beijing");
        System.out.println(methodsWithStreams.getOrderedCapitals(countriesAndCapitals));

        List<String> lines = List.of("abba", "baab", "caac", "acca", "beeb", "ecce", "boo", "bi", "basketball ");
        System.out.println(methodsWithStreams.getOrderedStringsWithSymbol(lines, 'b'));

        List<Integer> integers = List.of(54, 87, 2, 6, 785, 10245800);
        System.out.println(methodsWithStreams.getBinaryStrings(integers));

        List<String> strings = List.of("aaaa", "bb", "cc", "aasb", "asdf", "dge", "ddr", "pjj", "tjv");
        System.out.println(methodsWithStreams.getOrderedString(strings, "abcdefgs"));
    }


}
