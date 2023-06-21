package faang.school.godbless.task6_calculator;

import faang.school.godbless.sprint3.task6_calculator.Main;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void testSumEmpty() {
        assertEquals(0, Main.sum(new ArrayList<>()));
    }

    @Test
    void testSumOneElement() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(1, Main.sum(list));
    }

    @Test
    void testSumDefoliate() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(15, Main.sum(list));
    }


    @Test
    void testProductEmpty() {
        assertEquals(0, Main.sum(new ArrayList<>()));
    }

    @Test
    void testProductOneElement() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        assertEquals(1, Main.sum(list));
    }

    @Test
    void testProductDefoliate() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        assertEquals(6, Main.sum(list));
    }
}