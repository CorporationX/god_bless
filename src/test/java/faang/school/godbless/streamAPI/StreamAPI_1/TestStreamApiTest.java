package faang.school.godbless.streamAPI.StreamAPI_1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestStreamApiTest {
    List<Integer> integerList = List.of(23, 2, 34, 12, 5);
    List<String> stringList = List.of("Протокольный", "Присыпать", "Тарантул");

    @Test
    void getSumInt() {
        int expected = 76;
        int result = TestStreamApi.getSumInt(integerList);

        assertEquals(expected, result);
    }

    @Test
    void getMaxInt() {
        int expected = 34;
        int result = TestStreamApi.getMaxInt(integerList);

        assertEquals(expected, result);
    }

    @Test
    void getAverageInt() {
        double expected = 15.2;
        double result = TestStreamApi.getAverageInt(integerList);

        assertEquals(expected, result);
    }

    @Test
    void getQuantityFirstEntry() {
        int expected = 2;
        int result = TestStreamApi.getQuantityFirstEntry(stringList, "Пр");

        assertEquals(expected, result);
    }

    @Test
    void getFilterSubstring() {
        List<String> expected = List.of("Присыпать");
        List<String> result = TestStreamApi.getFilterSubstring(stringList, "Присыпать");

        assertEquals(expected, result);
    }

    @Test
    void getFilterLength() {
        List<String> expected = List.of("Тарантул");
        List<String> result = TestStreamApi.getFilterLength(stringList, 10);

        assertEquals(expected.get(0), result.get(0));
    }

    @Test
    void getMinFromListButMoreNumber() {
        int expected = 12;
        int result = TestStreamApi.getMinFromListButMoreNumber(integerList, 10);

        assertEquals(expected, result);
    }

    @Test
    void TestGetMapStringLength() {
        List<Integer> expected = List.of(12, 9, 8);
        List<Integer> result = TestStreamApi.getMapStringLength(stringList);

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }
}