package faang.school.godbless.stream.training;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamOpsTest {

    private final List<Integer> testNumbers = List.of(1, 2, 3, 4, 5, 6);
    private final List<String> testStrings =
            List.of("Best Buy", "Best Footbal Championship", "Beastie Boys", "Beatles");

    @Test
    void sumEven() {
        int result = StreamOps.sumEven(testNumbers);

        assertEquals(12, result);
    }

    @Test
    void findMax() {
        int result = StreamOps.findMax(testNumbers);

        assertEquals(6, result);
    }

    @Test
    void findAverage() {
        double result = StreamOps.findAverage(testNumbers);

        assertEquals(3.5, result);
    }

    @Test
    void countStringsStartingWithSymbol() {
        var twitterHandles = List.of("@joey", "margo", "@stan", "@musk", "@trevor");

        long handlesCount = StreamOps.countStringsStartingWithSymbol(twitterHandles, "@");

        assertEquals(4, handlesCount);
    }

    @Test
    void filterStringsWithSubstring() {
        List<String> filteredStrings = StreamOps.filterStringsWithSubstring(testStrings, "best");

        assertEquals(2, filteredStrings.size());
    }

    @Test
    void sortByLength() {
        List<String> strings = StreamOps.sortByLength(testStrings);

        assertEquals("Beatles", strings.get(0));
        assertEquals("Best Footbal Championship", strings.get(3));
    }

    @Test
    void areAllValid() {
        assertTrue(StreamOps.areAllValid(testStrings, (string) -> string.toLowerCase().contains("b")));
    }


    @Test
    void findSmallestNumberGreaterThan() {
        var result = StreamOps.findSmallestNumberGreaterThan(testNumbers, 3);

        assertEquals(4, result);
    }

    @Test
    void findSmallestNumberGreaterThan_IfInputIsEqualToMax() {
        var result = StreamOps.findSmallestNumberGreaterThan(testNumbers, 6);

        assertEquals(0, result);
    }

    @Test
    void transformStringsIntoLengths() {
        var numbers = StreamOps.transformStringsIntoLengths(List.of("one", "two"));

        assertEquals(3, numbers.get(0));
        assertEquals(3, numbers.get(1));
    }
}