package school.faang.bjs2_70769;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StreamTrainerTest {

    Set<Integer> set;
    Map<String, String> map;
    List<String> strings;
    List<Integer> integers;
    char testChar;
    String s;

    @BeforeEach
    void setUp() {
        set = Set.of(1, 2, 3, 4, 5);
        map = new HashMap<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        strings = List.of("a2", "a13", "a114", "d1115", "e11116");
        testChar = 'a';
        integers = List.of(1, 2, 3, 4);
        s = "abcfg";
    }

    @Test
    public void findUniquePairs() {
        Set<List<Integer>> result = StreamTrainer.findUniquePairs(set, 5);
        Set<List<Integer>> expectedSet = Set.of(
                List.of(1, 4),
                List.of(2, 3)
        );
        Assertions.assertEquals(expectedSet, result);
    }

    @Test
    public void getSortedCapitals() {
        List<String> result = StreamTrainer.getSortedCapitals(map);
        List<String> expectedList = List.of("b", "d", "f");
        Assertions.assertEquals(expectedList, result);
    }

    @Test
    public void filterSortedStrings() {
        List<String> result = StreamTrainer.filterSortedStrings(strings, testChar);
        List<String> expectedList = List.of("a2", "a13", "a114");
        Assertions.assertEquals(expectedList, result);
    }

    @Test
    public void converToBinary() {
        List<String> result = StreamTrainer.convertToBinary(integers);
        List<String> expectedList = List.of("1", "10", "11", "100");
        Assertions.assertEquals(expectedList, result);
    }

    @Test
    public void filterStringsViaAlphabet() {
        List<String> result = StreamTrainer.filterStringsViaAlphabet(strings, s);
        List<String> expectedList = List.of("a2", "a13", "a114");
    }
}
