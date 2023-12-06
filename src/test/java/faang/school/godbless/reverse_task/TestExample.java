package faang.school.godbless.reverse_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static faang.school.godbless.reverse_task.Example.reverse;

public class TestExample {
    @Test
    public void testReverse() {
        int[] testArray = new int[] {1, 2, 3, 4, 5, 6};
        int[] reversedArray = new int[] {6, 5, 4, 3, 2, 1};

        reverse(testArray);

        Assertions.assertEquals(testArray[0], reversedArray[0]);
        Assertions.assertEquals(testArray[testArray.length - 1],
                reversedArray[reversedArray.length - 1]);
    }
}
