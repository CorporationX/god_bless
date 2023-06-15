package Task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestExample {
    @Test
    public void testReverse(){
        int[] list = new int[]{1, 2, 3, 4, 5, 6};
        Example example = new Example();
        int[] a = example.reverse(list);
        int[] z = new int[]{6,5,4,3,2,1};
        Assertions.assertArrayEquals(a,z);
    }
}
