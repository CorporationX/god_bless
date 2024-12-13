package school.faang.sprint_2.task_bjs245679;

import java.util.List;

public class Main {

    private static final Calculator<Byte> BYTE_SUM_CALCULATOR = (a, b) -> {
        int result = a + b;
        if (result > 127) {
            throw new IllegalArgumentException("Результат сложения превышает диапазон Byte. Используйте другой тип");
        }
        return (byte) result;
    };
    private static final Calculator<Byte> BYTE_PRODUCT_CALCULATOR = (a, b) -> {
        int result = a * b;
        if (result > 127) {
            throw new IllegalArgumentException("Результат умножения превышает диапазон Byte. Используйте другой тип");
        }
        return (byte) result;
    };
    private static final String INITIAL_VALUE_ZERO = "0";
    private static final String INITIAL_VALUE_ONE = "1";

    public static void main(String[] args) {
        List<Integer> integerNumbers = List.of(2, 3);
        Integer sumOfIntegers = calculate(integerNumbers, Integer.valueOf(INITIAL_VALUE_ZERO), (Integer::sum));
        Integer productOfIntegers = calculate(integerNumbers, Integer.valueOf(INITIAL_VALUE_ONE), (a, b) -> a * b);
        System.out.println("-----Integer numbers: " + integerNumbers);
        System.out.println("Sum of integers = " + sumOfIntegers);
        System.out.println("Product of integers = " + productOfIntegers);

        List<Long> longNumbers = List.of(2L, 3L, 4L);
        Long sumOfLongs = calculate(longNumbers, Long.valueOf(INITIAL_VALUE_ZERO), (Long::sum));
        Long productOfLongs = calculate(longNumbers, Long.valueOf(INITIAL_VALUE_ONE), (a, b) -> a * b);
        System.out.println("-----Long numbers: " + longNumbers);
        System.out.println("Sum of longs = " + sumOfLongs);
        System.out.println("Product of longs = " + productOfLongs);

        List<Float> floatNumbers = List.of(2F, 2.5F, 3F);
        Float sumOfFloats = calculate(floatNumbers, Float.valueOf(INITIAL_VALUE_ZERO), (Float::sum));
        Float productOfFloats = calculate(floatNumbers, Float.valueOf(INITIAL_VALUE_ONE), (a, b) -> a * b);
        System.out.println("-----Float numbers: " + floatNumbers);
        System.out.println("Sum of floats = " + sumOfFloats);
        System.out.println("Product of floats = " + productOfFloats);

        List<Double> doubleNumbers = List.of(3.0, 4.0, 5.0);
        Double sumOfDoubles = calculate(doubleNumbers, Double.valueOf(INITIAL_VALUE_ZERO), (Double::sum));
        Double productOfDoubles = calculate(doubleNumbers, Double.valueOf(INITIAL_VALUE_ONE), (a, b) -> a * b);
        System.out.println("-----Double numbers: " + doubleNumbers);
        System.out.println("Sum of doubles = " + sumOfDoubles);
        System.out.println("Product of doubles = " + productOfDoubles);

        List<Byte> byteNumbers = List.of((byte) 4, (byte) 5, (byte) 6);
        Byte sumOfBytes = calculate(byteNumbers, Byte.valueOf(INITIAL_VALUE_ZERO), BYTE_SUM_CALCULATOR);
        Byte productOfBytes = calculate(byteNumbers, Byte.valueOf(INITIAL_VALUE_ONE), BYTE_PRODUCT_CALCULATOR);
        System.out.println("-----Byte numbers: " + byteNumbers);
        System.out.println("Sum of bytes = " + sumOfBytes);
        System.out.println("Product of bytes = " + productOfBytes);

        List<Short> shortNumbers = List.of((short) 7, (short) 8, (short) 9);
        Short sumOfShorts = calculate(shortNumbers, Short.valueOf(INITIAL_VALUE_ZERO), (a, b) -> (short) (a + b));
        Short productOfShorts = calculate(shortNumbers, Short.valueOf(INITIAL_VALUE_ONE), (a, b) -> (short) (a * b));
        System.out.println("-----Short numbers: " + shortNumbers);
        System.out.println("Sum of shorts = " + sumOfShorts);
        System.out.println("Product of shorts = " + productOfShorts);
    }

    private static <T extends Number> T calculate(
            List<T> numbers,
            T initialValue,
            Calculator<T> calculator
    ) throws IllegalArgumentException {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Null or empty list of numbers!");
        }
        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        return numbers.stream()
                .reduce(initialValue, calculator::calculate);
    }

}
