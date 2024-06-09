package unittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberConverterTest {
    private NumberConverter numberConverter;

    @BeforeEach
    public void setUp() {
        numberConverter = new NumberConverter();
    }

    // позитивные

    // Переводим число из 10 в 2 систему
    // 10 -> 1010
    @Test
    public void testConvertDecimalToBinary() {
        // arrange
        String number = "10";
        int sourceBase = 10;
        int targetBase = 2;

        // act
        String result = numberConverter.convertNumber(number, sourceBase, targetBase);

        // assert
        assertEquals("1010", result);
    }

    // Перевести число из 16 в 10 систему
    // FF -> 255
    @Test
    public void testConvertHexadecimalToDecimal() {
        // arrange
        String number = "FF";
        int sourceBase = 16;
        int targetBase = 10;

        // act
        String result = numberConverter.convertNumber(number, sourceBase, targetBase);

        // assert
        assertEquals("255", result);
    }

    // Перевести число из 10 в 16 систему
    // 255 -> FF
    @Test
    public void testConvertDecimalToHexadecimal() {
        // arrange
        String number = "255";
        int sourceBase = 10;
        int targetBase = 16;

        // act
        String result = numberConverter.convertNumber(number, sourceBase, targetBase);

        // assert
        assertEquals("FF", result);
    }

    // Перевести число из 8 в 2 систему
    // 17 -> 1111
    @Test
    public void testConvertOctalToBinary() {
        // arrange
        String number = "17";
        int sourceBase = 8;
        int targetBase = 2;

        // act
        String result = numberConverter.convertNumber(number, sourceBase, targetBase);

        // assert
        assertEquals("1111", result);
    }

    // негативные

    // некорректное значение исходной системы
    // sourceBase = 1
    @Test
    public void testIncorrectSourceBase() {
        // arrange
        String number = "17";
        int sourceBase = 1;
        int targetBase = 2;


        // act, assert
        assertThrows(IllegalArgumentException.class, () ->numberConverter.convertNumber(number, sourceBase, targetBase));
    }

    // некорректное значение целевой системы
    // targetBase = 37
    @Test
    public void testIncorrectTargetBase() {
        // arrange
        String number = "17";
        int sourceBase = 2;
        int targetBase = 37;


        // act, assert
        assertThrows(IllegalArgumentException.class, () ->numberConverter.convertNumber(number, sourceBase, targetBase));
    }

    // некорректное число
    // number = "XYZ"
    @Test
    public void testIncorrectNumber() {
        // arrange
        String number = "XYZ";
        int sourceBase = 16;
        int targetBase = 2;


        // act, assert
        assertThrows(IllegalArgumentException.class, () ->numberConverter.convertNumber(number, sourceBase, targetBase));
    }

    // Позитивные параметризированные тесты
    @ParameterizedTest
    @CsvSource({"101, 2, 10, 5", "10, 10, 2, 1010", "FF, 16, 10, 255"})
    public void testConvertNumber(String number, int sourceBase, int targetBase, String expected){

        // act
        String result = numberConverter.convertNumber(number, sourceBase, targetBase);

        // assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("numberProvider") // Метод, который генерирует значения аргументов
    public void testConvertNumberMethodSource(String number, int sourceBase, int targetBase, String expected){

        // act
        String result = numberConverter.convertNumber(number, sourceBase, targetBase);

        // assert
        assertEquals(expected, result);
    }

    public static Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of("101", 2, 10, "5"),
                Arguments.of("10", 10, 2, "1010"),
                Arguments.of("FF", 16, 10, "255")
        );
    }
}