package faang.school.godbless.stream_api1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ExampleTest {

    @Test
    void getSumTest(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int result = Example.getSumNum(list);
        int expected = 15;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getMaxTest(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int result = Example.getMax(list);
        int expected = 5;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAverageTest(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        double result = Example.getAverage(list);
        double expected = 3;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getStringNumTest(){
        List<String> list = List.of("Summer", "Sum", "Village", "host", "bear");
        Character ch = 's';
        double result = Example.getStringNum(list, ch);
        double expected = 2;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void filterBySubstringTest(){
        List<String> list = List.of("Summer", "Sum", "Village", "host", "bear");
        String subString = "sum";
        int result = Example.filterBySubstring(list, subString).size();
        int expected = 2;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void sortBySizeTest(){
        List<String> list = List.of("Summer", "Sum", "Village", "host", "sneakers");
        List<String> result = Example.sortByStringLenght(list);
        List<String> expected = List.of("Sum", "host", "Summer", "Village", "sneakers");

        Assertions.assertEquals(expected, result);
    }

    @Test
    void isSizeEvenTest(){
        List<String> list = List.of("Summer", "Sum", "Village", "host", "sneakers");
        boolean result = Example.isLengthEven(list);
        boolean expected = false;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getNumTest(){
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        int result = Example.getNum(list, 3);
        int expected = 4;

        Assertions.assertEquals(expected, result);
    }

    @Test
    void getStringLengthTest(){
        List<String> list = List.of("Summer", "Sum", "Village", "host", "sneakers");
        List<Integer> result = Example.getStringLength(list);
        List<Integer> expected = List.of(6, 3, 7, 4, 8);

        Assertions.assertEquals(expected, result);
    }
}
