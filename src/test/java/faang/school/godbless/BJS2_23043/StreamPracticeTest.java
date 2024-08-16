package faang.school.godbless.BJS2_23043;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class StreamPracticeTest {
    private List<Integer> integers;
    List<String> strings;

    @BeforeEach
    void setUp() {
        integers = new ArrayList<>(
                List.of(23, 87, 12, 34, 56, 45, 78, 90, 11, 67, 88, 43, 19, 54, 72)
        );
        strings = new ArrayList<>(
                List.of(
                        "apple",
                        "banana",
                        "apricot",
                        "cherry",
                        "avocado",
                        "blueberry",
                        "cranberry",
                        "almond",
                        "date",
                        "grape"
                )
        );
    }

    @Test
    void findSumEvenNumbers() {
        var result = StreamPractice.findSumOfEvenNumbers(integers);
        assertThat(result).isEqualTo(484);
    }

    @Test
    void findMaxElement() {
        var result = StreamPractice.findMaxElement(integers);
        assertThat(result).isEqualTo(90);
    }

    @Test
    void findAverage() {
        var result = StreamPractice.findAverage(integers);
        assertThat(result).isEqualTo(51.93);
    }

    @Test
    void getStringsCount() {
        var aCount = StreamPractice.getStringsCount(strings, 'a');
        var bCount = StreamPractice.getStringsCount(strings, 'b');
        assertThat(aCount).isEqualTo(4);
        assertThat(bCount).isEqualTo(2);
    }

    @Test
    void getSubstrings() {
        var result = StreamPractice.getSubstrings(strings, "berry");
        assertThat(result).contains("blueberry", "cranberry").hasSize(2);
    }

    @Test
    void sortStringsByLength() {
        List<String> result = StreamPractice.sortStringsByLength(strings);
        assertThat(result.get(0)).isEqualTo("date");
        assertThat(result.get(result.size() - 1)).isEqualTo("cranberry");
    }

    @Test
    void checkElements() {
        Predicate<String> predicate = str -> str.length() > 5;
        var result = StreamPractice.checkElements(strings, predicate);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void findLessThen() {
        var result = StreamPractice.findLessThen(integers, 45);
        assertThat(result).isEqualTo(54);
    }

    @Test
    void mapStringsToTheirLengths() {
        var result = StreamPractice.mapStringsToTheirLengths(strings);
        assertThat(result).hasSize(10);
        assertThat(result.get(0)).isEqualTo(5);
        assertThat(result.get(5)).isEqualTo(9);
    }
}