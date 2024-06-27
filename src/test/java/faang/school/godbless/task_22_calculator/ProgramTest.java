package faang.school.godbless.task_22_calculator;

import faang.school.godbless.sprint_2.functional_interface.task_22_calculator.Program;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProgramTest {

    @Test
    public void testCalculate_list() {
        // Arrange
        List<Integer> numbers = List.of(2, 4, 6);
        int expectationSum = 12;
        int expectationProduct = 48;

        // Act
        int actualSum = Program.sum(numbers);
        int actualProduct = Program.product(numbers);

        // Assert
        assertEquals(expectationSum, actualSum, "суммы различаются");
        assertEquals(expectationProduct, actualProduct, "произведения различаются");
    }

    @Test
    public void testCalculate_throwsIllegalArgumentException() {
        // Arrange
        List<Integer> listEmpty = new ArrayList<>();
        List<Integer> listNull = null;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> Program.sum(listEmpty), "При передачи пустого списка метод должен выбрасывать IllegalArgumentException");
        assertThrows(IllegalArgumentException.class, () -> Program.sum(listNull), "При передачи null метод должен выбрасывать IllegalArgumentException");
    }


}
