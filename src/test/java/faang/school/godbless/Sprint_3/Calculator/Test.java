package faang.school.godbless.Sprint_3.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static faang.school.godbless.Sprint_3.Calculator.Application.product;
import static faang.school.godbless.Sprint_3.Calculator.Application.sum;
import static org.junit.jupiter.api.Assertions.*;

class Test {
    @org.junit.jupiter.api.Test
    public void POSITIVE_productTest() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int res = product(nums);

        assertEquals(res, 120);
    }
    @org.junit.jupiter.api.Test
    public void POSITIVE_sumTest() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int res = sum(nums);

        assertEquals(res, 15);
    }

    @org.junit.jupiter.api.Test
    public void NEGATIVE_productTest() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int res = product(nums);

        assertEquals(res, 15);
    }

    @org.junit.jupiter.api.Test
    public void NEGATIVE_sumTest() {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int res = sum(nums);

        assertEquals(res, 120);
    }


}