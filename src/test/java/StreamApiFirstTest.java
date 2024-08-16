import faang.school.godbless.streamApiTrain.FirstTrain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        long count = FirstTrain.getCount(Arrays.asList(
                "give me a money",
                "gave me a money",
                "take my money",
                "suck my money",
                "gg"
        ), 'g');

        Assertions.assertEquals(3L, count);
    }


}
