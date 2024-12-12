package school.faang.sprint_2.task_bjs245679;

import java.util.List;

public class Main {

    private static final Calculator<Byte> BYTE_SUM_CALCULATOR = (a, b) -> {
        if (a + b > 127) {
            throw new IllegalArgumentException("Результат сложения превышает диапазон Byte. Используйте другой тип");
        }
        return (byte) (a + b);
    };
    private static final Calculator<Byte> BYTE_PRODUCT_CALCULATOR = (a, b) -> {
        if (a * b > 127) {
            throw new IllegalArgumentException("Результат умножения превышает диапазон Byte. Используйте другой тип");
        }
        return (byte) (a * b);
    };
    private static final String INITIAL_VALUE_ZERO = "0";
    private static final String INITIAL_VALUE_ONE = "1";

    public static void main(String[] args) {
        List<Integer> integerNumbers = List.of(2, 3);
        Integer sumOfIntegers = sum(integerNumbers, (Integer::sum));
        Integer productOfIntegers = product(integerNumbers, (a, b) -> a * b);
        System.out.println("-----Integer numbers: " + integerNumbers);
        System.out.println("Sum of integers = " + sumOfIntegers);
        System.out.println("Product of integers = " + productOfIntegers);

        List<Long> longNumbers = List.of(2L, 3L, 4L);
        Long sumOfLongs = sum(longNumbers, (Long::sum));
        Long productOfLongs = product(longNumbers, (a, b) -> a * b);
        System.out.println("-----Long numbers: " + longNumbers);
        System.out.println("Sum of longs = " + sumOfLongs);
        System.out.println("Product of longs = " + productOfLongs);

        List<Float> floatNumbers = List.of(2F, 2.5F, 3F);
        Float sumOfFloats = sum(floatNumbers, (Float::sum));
        Float productOfFloats = product(floatNumbers, (a, b) -> a * b);
        System.out.println("-----Float numbers: " + floatNumbers);
        System.out.println("Sum of floats = " + sumOfFloats);
        System.out.println("Product of floats = " + productOfFloats);

        List<Double> doubleNumbers = List.of(3.0, 4.0, 5.0);
        Double sumOfDoubles = sum(doubleNumbers, (Double::sum));
        Double productOfDoubles = product(doubleNumbers, (a, b) -> a * b);
        System.out.println("-----Double numbers: " + doubleNumbers);
        System.out.println("Sum of doubles = " + sumOfDoubles);
        System.out.println("Product of doubles = " + productOfDoubles);

        List<Byte> byteNumbers = List.of((byte) 4, (byte) 5, (byte) 6);
        Byte sumOfBytes = sum(byteNumbers, BYTE_SUM_CALCULATOR);
        Byte productOfBytes = product(byteNumbers, BYTE_PRODUCT_CALCULATOR);
        System.out.println("-----Byte numbers: " + byteNumbers);
        System.out.println("Sum of bytes = " + sumOfBytes);
        System.out.println("Product of bytes = " + productOfBytes);

        List<Short> shortNumbers = List.of((short) 7, (short) 8, (short) 9);
        Short sumOfShorts = sum(shortNumbers, (a, b) -> (short) (a + b));
        Short productOfShorts = product(shortNumbers, (a, b) -> (short) (a * b));
        System.out.println("-----Short numbers: " + shortNumbers);
        System.out.println("Sum of shorts = " + sumOfShorts);
        System.out.println("Product of shorts = " + productOfShorts);
    }

    public static <T extends Number> T sum(List<T> numbers, Calculator<T> calculator) {
        return calculate(numbers, calculator, INITIAL_VALUE_ZERO);
    }

    public static <T extends Number> T product(List<T> numbers, Calculator<T> calculator) {
        return calculate(numbers, calculator, INITIAL_VALUE_ONE);
    }

    private static <T extends Number> T calculate(
            List<T> numbers,
            Calculator<T> calculator,
            String identityValue
    ) throws IllegalArgumentException {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Null or empty list of numbers!");
        }
        if (numbers.size() == 1) {
            return numbers.get(0);
        }
        T identity = getIdentity(numbers, identityValue);

        return numbers.stream()
                .reduce(identity, calculator::calculate);
    }

    @SuppressWarnings("Unchecked")
    private static <T extends Number> T getIdentity(List<T> numbers, String value) {
        T referenceNumber = numbers.get(0);
        T result;
        if (referenceNumber instanceof Integer) {
            result = (T) Integer.valueOf(value);
        } else if (referenceNumber instanceof Long) {
            result = (T) Long.valueOf(value);
        } else if (referenceNumber instanceof Float) {
            result = (T) Float.valueOf(value);
        } else if (referenceNumber instanceof Double) {
            result = (T) Double.valueOf(value);
        } else if (referenceNumber instanceof Byte) {
            result = (T) Byte.valueOf(value);
        } else if (referenceNumber instanceof Short) {
            result = (T) Short.valueOf(value);
        } else {
            throw new IllegalArgumentException("Type must be number successor!");
        }
        return result;
    }
}
