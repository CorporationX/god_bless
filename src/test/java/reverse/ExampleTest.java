package reverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    public void shouldReverseNumbersArray() {
        Example example = new Example();
        int[] actualNums = {9,8,7,6,5,4,3,2,1,0};
        int[] expectedNums = {0,1,2,3,4,5,6,7,8,9};

        example.reverse(actualNums);

        Assertions.assertArrayEquals(expectedNums, actualNums);
    }
}
