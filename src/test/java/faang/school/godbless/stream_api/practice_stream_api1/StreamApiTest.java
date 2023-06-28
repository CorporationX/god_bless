package faang.school.godbless.stream_api.practice_stream_api1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamApiTest {
    @Test
    public void evenSum_shouldReturnSumOfEven() {
        var nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertEquals(30, StreamApi.evenSum(nums));
    }

    @Test
    public void maxNum_shouldReturnMaxOfNums() {
        var nums = List.of(1, 2, 5, 3, 6, 8);
        assertEquals(8, StreamApi.maxNum(nums));
    }

    @Test
    public void avg_shouldReturnAverageOfNums() {
        var nums = List.of(2, 4, 1, 3);
        assertEquals(2.5, StreamApi.avg(nums));
    }

    @Test
    public void count_shouldReturnCountOfFilteredStrings() {
        var stringList = List.of("Alabama", "California", "Alaska", "Colorado", "Arizona", "Arkansas");
        assertEquals(4, StreamApi.count(stringList));
    }

    @Test
    public void filter_shouldReturnFilteredStringList() {
        var stringList = List.of("32111344", "123214324", "881811190", "90890809809");
        var result = StreamApi.filter(stringList);
        assertEquals(2, result.size());
        assertTrue(result.contains("32111344"));
        assertTrue(result.contains("881811190"));
    }

    @Test
    public void sortByLength_shouldReturnSortedStringList() {
        var stringList = List.of("aaaaaaaaa", "aaa", "aaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaa");
        var result = StreamApi.sortByLength(stringList);
        assertEquals("aaa", result.get(0));
        assertEquals("aaaaaaaaaaaaaaaaa", result.get(result.size() - 1));
    }

    @Test
    public void allMatch_shouldReturnAllMatchOrNot() {
        var numList = List.of(12, 13, 34, 45, 654);
        assertTrue(StreamApi.allMatch(numList));
    }

    @Test
    public void leastNum_shouldReturnLeastNumMoreThanCondition() {
        var numList = List.of(12, 13, 34, 45, 654);
        var condition = 20;
        assertEquals(34, StreamApi.leastNum(numList, condition));
    }

    @Test
    public void toLengthList_shouldReturnListOfLength() {
        var stringList = List.of("Alabama", "California", "Alaska");
        var result = StreamApi.toLengthList(stringList);
        assertEquals(7, result.get(0));
        assertEquals(10, result.get(1));
        assertEquals(6, result.get(2));
    }

}
