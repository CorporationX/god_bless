package school.faang.task_57825;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class Main {
    private static final List<String> STRINGS = List.of("apple", "banana", "cherry", "date", "fig", "grape");
    private static final Set<Integer> INTEGER_SET = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private static final Map<String, String> STRING_MAP = new HashMap<>();
    private static final List<String> STRINGS_FRUTS = List.of("apple", "banana", "avocado", "apricot");
    private static final List<Integer> INTEGERS_LIST = List.of(1, 2, 3, 4);

    public static void main(String[] args) {

        List<String> list2 = ListOperations.filterAndSortByLength(STRINGS, "abcdefghijklmnopqrstuvwxyz");
        log.info(list2.toString());

        Set<List<Integer>> set = ListOperations.findPairs(INTEGER_SET, 6);
        log.info(set.toString());

        STRING_MAP.put("Russia", "Moscow");
        STRING_MAP.put("USA", "Washington");
        STRING_MAP.put("Germany", "Berlin");

        List<String> listSity = ListOperations.getSortedCapitals(STRING_MAP);
        log.info(listSity.toString());

        List<String> fruts = ListOperations.filterAndSort(STRINGS_FRUTS, 'a');
        log.info(fruts.toString());

        List<String> integerToString = ListOperations.convertToBinary(INTEGERS_LIST);
        log.info(integerToString.toString());


    }
}
