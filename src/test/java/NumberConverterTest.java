import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberConverterTest {
    private NumberConverter number;

    @BeforeEach
    void setup(){
        number = new NumberConverter();
    }
    @Test
    void convertToBinary(){
        String name = "17";
        int first = 8;
        int secjnd = 2;
        String result = number.convertNumber(name, first, secjnd);
        //assertEquals("1111", result);
        assertThrows(IllegalAccessException.class, () -> number.convertNumber(name, first, secjnd));
    }
}
