import org.example.service.Example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MassiveReverseTest {
    @Test
    @DisplayName("Reverse massive")
    void testReverseMassive() {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int[] reversedMassive = new int[]{5, 4, 3, 2, 1};

        Example.reverse(nums);

        assertEquals(Arrays.toString(reversedMassive), Arrays.toString(nums));
    }
}
