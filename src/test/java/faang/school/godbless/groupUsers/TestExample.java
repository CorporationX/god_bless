package faang.school.godbless.groupUsers;

import faang.school.godbless.turnaround.Example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestExample {

    @Test
    @DisplayName("Reverse array")
    public void testReverse() {
        int[] arrayOdd = {0,1,2,3,4,5,6,7,8};
        int[] arrayEven = {0,1,2,3,4,5,6,7,8,9};

        Example.reverse(arrayOdd);
        Example.reverse(arrayEven);

        assertAll(
                () -> assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0}, arrayOdd),
                () -> assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, arrayEven)
        );
    }
}
