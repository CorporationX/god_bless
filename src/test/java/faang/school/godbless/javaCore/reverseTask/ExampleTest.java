package faang.school.godbless.javaCore.reverseTask;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.javaCore.reverseTask.Example.reverse;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ExampleTest {

    @Test
    void testReverse() {
        //given
        var nums = new int[]{1, 2, 5, 5, 6};
        var reversedArray = new int[]{6, 5, 5, 2, 1};

        //when
        var reverseResult = reverse(nums);

        //then
        for(int i = 0; i < reverseResult.length; i++) {
            assertEquals(reversedArray[i], reverseResult[i]);
        }
    }
}