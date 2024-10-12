package school.faang.streamapi2;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    //1
    public static Set<List<Integer>> findUniqPairNumbers(List<Integer> listOfNumbers, Integer singleNumber) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(listOfNumbers);
        pairs = listOfNumbers.stream()
                .filter(num -> set.contains(singleNumber - num))
                .map(num -> Arrays.asList(num, singleNumber - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;

    }

    //2
    public static List<String> mapCountryWithCapitals(Map<String, String> map) {
        return map.entrySet().
                stream().sorted(Map.Entry.comparingByKey()).map(entry -> entry.getValue())
                .collect(Collectors.toList());
        //return sortedEntries;
    }

    //3
    public static List<String> filerAndSort(List<String> list, char symbol) {
       return list.stream()
               .filter(element -> element.startsWith(Character.toString(symbol)))
               .sorted((x, y) -> x.length()  - (y.length()))
               .collect(Collectors.toList());
    }

    //4
    public static List<String> numbersToBinaryString(List<Integer> list) {
        return  list.stream()
                .map(num -> Integer.toBinaryString(num))  //Integer::toBinaryString
                .collect(Collectors.toList());
    }

    //5
    public static List<String> filerForAlphabet(List<String> list, String alphabet) {
        String regex  = "[" + alphabet + "]+";
        return list.stream()
                .filter(s -> s.matches(regex))
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
    }
}
