package ru.kraiush.BJS2_18616.turn.around;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.turn.around.Example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {

    @Test
    public void testReverse() {
        //arrange
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] expected = {6, 5, 4, 3, 2, 1};

        //act
        Example.reverse(nums);

        //assert
        assertArrayEquals(expected, nums);
    }

    @Test
    @DisplayName("Разворот - массив с одним элементом")
    public void reverse_withSingleElementArr_returnSameArr() {
        //arrange
        int[] nums = {1};

        //act
        Example.reverse(nums);

        //assert
        assertArrayEquals(new int[] {1}, nums);
    }

    @Test
    @DisplayName("Разворот - пустой массив")
    public void reverse_withEmptyArr_returnSameArr() {
        //arrange
        int[] nums = {};

        //act
        Example.reverse(nums);

        //assert
        assertArrayEquals(new int[] {}, nums);
    }
}
