package school.faang.calculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculateServiceTest {
    private List<Integer> nums;
    private List<Integer> oneNum;
    private List<Integer> emptyList;

    @BeforeEach
    public void setUp() {
        nums = Arrays.asList(1, 2, 3, 4, 5);
        oneNum = List.of(1);
        emptyList = List.of();
    }

    @Test
    public void productTest() {
        assertEquals(120, CalculateService.product(nums));
    }

    @Test
    public void productOneElementTest() {
        assertEquals(1, CalculateService.product(oneNum));
    }

    @Test
    public void sumTest() {
        assertEquals(15, CalculateService.sum(nums));
    }

    @Test
    public void sumOneElementTest() {
        assertEquals(1, CalculateService.sum(oneNum));
    }

    @Test
    public void shouldThrowExceptionCalculateEmptyList() {
        assertThrows(IllegalArgumentException.class, () -> CalculateService.sum(emptyList));
    }
}
