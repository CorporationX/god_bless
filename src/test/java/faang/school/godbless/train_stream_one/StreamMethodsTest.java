package faang.school.godbless.train_stream_one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StreamMethodsTest {
    @Test
    public void testSumList() {
        Assertions.assertEquals(15, StreamMethods.getListSum(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    public void testMaxListValue() {
        Assertions.assertEquals(35, StreamMethods.getMaxListValue(List.of(1, 2, 35, 4, 5)));
    }

    @Test
    public void testAverageListValue() {
        Assertions.assertEquals(3, StreamMethods.getAverageListValue(List.of(2, 2, 4, 4)));
    }

    @Test
    public void testFilterListBySubstring() {
        Assertions.assertEquals(2, StreamMethods.filterListBySubstring(List.of("Hello", "okolo", "oko", "dog")).size());
    }

    @Test
    public void testFilteredElementCount() {
        Assertions.assertEquals(3, StreamMethods.getFilteredElementCount(List.of("Kirill", "Key", "Oko", "Knife")).size());
    }
}
