package faang.school.godbless.reverse;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void testReverseOddLengthArray() {
        var array = IntStream.iterate(1, n -> n + 1).limit(101).toArray();

        var expected = IntStream.iterate(101, n -> n - 1).limit(101).toArray();

        assertArrayEquals(expected, Example.reverse(array));
    }

    @Test
    void testReverseEvenLengthArray() {
        var array =  IntStream.iterate(1, n -> n + 1).limit(100).toArray();

        var expected =  IntStream.iterate(100, n -> n - 1).limit(100).toArray();

        assertArrayEquals(expected, Example.reverse(array));
    }
}