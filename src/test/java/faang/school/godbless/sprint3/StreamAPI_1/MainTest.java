package faang.school.godbless.sprint3.StreamAPI_1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    List<Integer> listInt = List.of(7, 1, 2, 3, 4, 5, 6);
    List<String> listString = List.of("add", "buy", "kill", "application", "ad");

    @Test
    void sumEvenTest() {
        int sumEven = listInt.stream().filter(a -> a % 2 == 0).parallel().mapToInt(Integer::intValue).sum();
        assertEquals(12, sumEven);
    }

    @Test
    void maxNumTest() {
        int maxNum = listInt.stream().max(Comparator.naturalOrder()).get();
        assertEquals(7, maxNum);
    }

    @Test
    void middleValueTest() {
        int middleValue = listInt.stream().mapToInt(Integer::intValue).sum() / listInt.size();
        assertEquals(4, middleValue);
    }

    @Test
    void minFromMore4Test() {
        int minFromMore4 = listInt.stream().filter(a -> a > 4).min(Comparator.naturalOrder()).get();
        assertEquals(5, minFromMore4);
    }

    @Test
    void countStringATest() {
        int countStringA = (int) listString.stream().filter(s -> s.toLowerCase().toCharArray()[0] == 'a').count();
        assertEquals(3, countStringA);
    }

    @Test
    void ListADTest() {
        List<String> listAD = listString.stream().filter(a -> a.toLowerCase().contains("ad")).toList();
        assertEquals(List.of("add", "ad"), listAD);
    }

    @Test
    void sortByLenTest() {
        List<String> sortByLen = listString.stream().sorted(Comparator.comparingInt(a -> a.length())).toList();
        assertEquals(List.of("ad", "add", "buy", "kill", "application"), sortByLen);
    }

    @Test
    void allMatchTest() {
        boolean allMatch = listString.stream().allMatch(a -> !a.isEmpty());
        assertTrue(allMatch);
    }

    @Test
    void listLenTest() {
        List<Integer> listLen = listString.stream().map(a -> a.length()).toList();
        assertEquals(List.of(3, 3, 4, 11, 2), listLen);
    }
}