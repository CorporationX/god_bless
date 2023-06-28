package faang.school.godbless.sprint3.Stream_Api_2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main = new Main();

    //1
    @ParameterizedTest
    @CsvSource({"'8,7,6,5,4,3,2,1',5,2",
            "'0,0',0,1",
            "'0',1,0"
    })
    void uniqueCouple(String input, int n, int expect) {
        Main main = new Main();
        List<Integer> in = Arrays.stream(input.split(",")).mapToInt(a -> Integer.parseInt(a)).boxed().toList();
        assertEquals(expect, main.uniqueCouple(in, n).size());
    }

    @ParameterizedTest
    @CsvSource({"'8,7,6,5,4,3,2,1',5,2",
            "'0,0',0,1",
            "'0',1,0"
    })
    void uniqueCouple2(String input, int n, int expect) {
        List<Integer> in = Arrays.stream(input.split(",")).mapToInt(a -> Integer.parseInt(a)).boxed().toList();
        assertEquals(expect, main.uniqueCouple2(in, n).size());
    }

    //2
    @Test
    void countrySort() {
        Map<String, String> map = Map.of("C_test1", "test1", "B_test2", "test2", "A_test3", "test3");
        assertEquals(List.of("test3", "test2", "test1"), Main.countrySort(map));
    }

    //3
    @Test
    void sortSpecialString() {
        List<String> expect = List.of("t1", "te2", "test3");
        assertEquals(expect, Main.sortSpecialString(List.of("test3", "te2", "fail", "t1"), 't'));
    }

    //6
    @Test
    void filterStringTest() {
        String alph = "abc";
        List<String> list = List.of("abcd", "ab", "a", "abc");
        assertEquals(List.of("a", "ab", "abc"), Main.filterString(list, alph));
    }

    //7
    @Test
    void doubleStyleTest() {
        List<Integer> input = List.of(1, 2, 3);
        assertEquals(List.of(1, 10, 11), Main.doubleStyle(input));
    }

    //8
    @Test
    void numbersPalindromeTest() {
        assertEquals(List.of(9, 11, 22), Main.numbersPalindrome(9, 22));
    }
}