package feed_peter_griffin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FoodDeliveryTaskTest {
    private String character;
    private int foodAmount;
    private FoodDeliveryTask foodDeliveryTask;

    @BeforeEach
    public void setUp() {
        character = "John";
        foodAmount = 5;
        foodDeliveryTask = new FoodDeliveryTask(character, foodAmount);
    }

    @Test
    public void testRun_ShouldPrintCorrectMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        foodDeliveryTask.run();

        assertTrue(outContent.toString().contains("John gets 5"));
        assertTrue(outContent.toString().contains("John eats 5"));

        System.setOut(originalOut);
    }
}