package faang.school.godbless.BJS2_21451;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    List<Integer> nums = List.of(3,4,5,6,7);

    @Test
    @DisplayName("Product method should multiply nums in list")
    void productTest() {
        int expect = 2520;
        int actual = Main.product(nums);
        assertEquals(expect, actual);
    }

    @Test
    @DisplayName("Sum method should sum nums in list")
    void sumTest() {
        int expect = 25;
        int actual = Main.sum(nums);
        assertEquals(expect, actual);
    }
}