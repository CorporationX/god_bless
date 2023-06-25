package faang.school.godbless.streamAPI.part1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamApiFunctionsTest {

    @Test
    void getEvenSumTestNull() {
        Integer result = StreamApiFunctions.getEvenSum(null);
        assertEquals(null, result);
    }

    @Test
    void getEvenSumTest() {
        List<Integer> integerList = Arrays.asList(-2, 3, 4, 5, 8, 11, 15);
        Integer result = StreamApiFunctions.getEvenSum(integerList);
        assertEquals(10, result);
    }

    @Test
    void getMaxValueTestNull() {
        Integer result = StreamApiFunctions.getMaxValue(null);
        assertEquals(null, result);
    }

    @Test
    void getMaxValueTest() {
        List<Integer> integerList = Arrays.asList(-2, 3, 4, 5, 8, 11, 15, -5000);
        Integer result = StreamApiFunctions.getMaxValue(integerList);
        assertEquals(15, result);
    }

    @Test
    void getMeanValueTest() {
        List<Integer> integerList = Arrays.asList(5, 0, 2, 3, -5);
        Double result = StreamApiFunctions.getMeanValue(integerList);
        assertEquals(1, result);
    }

    @Test
    void getCountStringsTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Россия");
        stringList.add("Путин");
        stringList.add("Водка");
        stringList.add("Роман");

        int result1 = StreamApiFunctions.getCountStrings(stringList, "Р");
        int result2 = StreamApiFunctions.getCountStrings(stringList, "р");
        int result3 = StreamApiFunctions.getCountStrings(stringList, "в");
        int result4 = StreamApiFunctions.getCountStrings(stringList, "у");

        assertEquals(2, result1);
        assertEquals(2, result2);
        assertEquals(1, result3);
        assertEquals(0, result4);
    }

    @Test
    void filterStringsTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Россия");
        stringList.add("Путин");
        stringList.add("вован");
        stringList.add("Водка");
        stringList.add("Роман");

        List<String> resultList = StreamApiFunctions.filterStrings(stringList, "ро");
        assertEquals(List.of("Россия", "Роман"), resultList);
    }
}