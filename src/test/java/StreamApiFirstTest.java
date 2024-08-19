import faang.school.godbless.streamApiTrain.FirstTrain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StreamApiFirstTest {

    @Test
    void evenSumTest() {
        int sum = FirstTrain.evenSum(Arrays.asList(
                1, 2, 3, 4, 5, 2, 4
        ));

        Assertions.assertEquals(12, sum);
    }

    @Test
    void getMaxTest() {
        int max = FirstTrain.getMax(Arrays.asList(
                1, 2, 3, 4, 5, 6, 7
        ));

        Assertions.assertEquals(7, max);
    }

    @Test
    void getAverageTest() {
        double average = FirstTrain.getAverage(Arrays.asList(
                2, 3, 4, 5, 6, 1
        ));

        Assertions.assertEquals(21d / 6d, average);
    }

    @Test
    void getCountTest() {
        long count = FirstTrain.getCountOfStringsStartsWithC(Arrays.asList(
                "give me a money",
                "gave me a money",
                "take my money",
                "suck my money",
                "gg"
        ), 'g');

        Assertions.assertEquals(3L, count);
    }

    @Test
    void filterCompareTest() {
        List<String> strings = FirstTrain.getStringsContainsString(Arrays.asList(
                "give me a money",
                "gave me a money",
                "take my money",
                "suck my money",
                "gg"
        ), "my");

        Assertions.assertEquals(Arrays.asList(
                "take my money",
                "suck my money"
        ), strings);
    }

    @Test
    void sortStringsTest() {
        List<String> strings = FirstTrain.sortStrings(Arrays.asList(
                "333",
                "22",
                "4444",
                "1",
                "55555"
        ));

        Assertions.assertEquals(Arrays.asList(
                "1",
                "22",
                "333",
                "4444",
                "55555"
        ), strings);
    }

    @Test
    void isFulfillTest() {
        List<Integer> list = Arrays.asList(
                3, 4, 5, 123, 145, 111, 234
        );

        boolean b1 = FirstTrain.isEveryoneIsSatisfied(list, x -> x > 2);
        boolean b2 = FirstTrain.isEveryoneIsSatisfied(list, x -> x > 10000);

        Assertions.assertTrue(b1);
        Assertions.assertFalse(b2);
    }

    @Test
    void maxIntBiggerThanFloorTest() {
        List<Integer> list = Arrays.asList(
                3, 4, 5, 123, 145, 111, 234
        );

        int max = FirstTrain.minIntBiggerThanFloor(list, 100);

        Assertions.assertEquals(111, max);

        Assertions.assertEquals(0, FirstTrain.minIntBiggerThanFloor(list, 1111111));
    }


    @Test
    void mapStringsToLengthsTest() {
        List<Integer> integers = FirstTrain.mapStringsToLengths(Arrays.asList(
                "333",
                "22",
                "4444",
                "1",
                "55555"
        ));

        Assertions.assertEquals(Arrays.asList(3, 2, 4, 1, 5), integers);
    }
}
