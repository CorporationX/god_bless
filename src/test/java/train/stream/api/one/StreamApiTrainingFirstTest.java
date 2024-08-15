package train.stream.api.one;

import faang.school.godbless.train.stream.api.one.StreamApiTrainingFirst;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamApiTrainingFirstTest {

    @Test
    void testSumEven() {
        Assertions.assertEquals(6, StreamApiTrainingFirst.sumEven(List.of(2, 3, 4)));
    }

    @Test
    void testGetMax() {
        Assertions.assertEquals(4, StreamApiTrainingFirst.getMax(List.of(2, 3, 4)));
    }

    @Test
    void testAverage() {
        Assertions.assertTrue(StreamApiTrainingFirst.getAverage(List.of(2, 3, 4, 1)) - 2.5 < 0.01);
    }

    @Test
    void testCountLinesStartsWith() {
        Assertions.assertEquals(2,
                StreamApiTrainingFirst.countLinesStartsWith(List.of("abv", "abc", "frt", "asd"), "ab"));
    }

    @Test
    void testContains() {
        List<String> resultList = StreamApiTrainingFirst.getListContains(List.of("daab", "rtab", "fghr", "gabb"), "ab");
        Assertions.assertEquals(3, resultList.size());
        Assertions.assertTrue(resultList.containsAll(List.of("daab", "rtab", "gabb")));
    }

    @Test
    void testSortByLength() {
        List<String> sortedLines = StreamApiTrainingFirst.sortByLength(List.of("aaa", "a", "aa"));
        Assertions.assertEquals("a", sortedLines.get(0));
        Assertions.assertEquals("aa", sortedLines.get(1));
        Assertions.assertEquals("aaa", sortedLines.get(2));
    }

    @Test
    void testAllMatch() {
        Assertions.assertTrue(StreamApiTrainingFirst.allMatch(List.of("adfs", "afdsfsf", "trgfas"), line -> line.contains("a")));
        Assertions.assertFalse(StreamApiTrainingFirst.allMatch(List.of("adfs", "afdsfsf", "trgfas"), line -> line.length() == 7));
    }

    @Test
    void testMinButMoreThan() {
        Assertions.assertEquals(3, StreamApiTrainingFirst.minButMoreThan(List.of(1, 4, 2, 3, 7, 8), 2));
    }

    @Test
    void testConvert() {
        Assertions.assertEquals(List.of(2, 3, 4, 1), StreamApiTrainingFirst.convert(List.of("aa", "aaa", "aaaa", "a")));
    }

}
