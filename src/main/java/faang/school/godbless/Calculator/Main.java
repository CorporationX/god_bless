package faang.school.godbless.Calculator;

import java.util.List;

public class Main {
    public static final List<Integer> NUMBERS = List.of(1,2,3,4,5);
    public static void main(String[] args) {
        System.out.println(sum());
        System.out.println(product());
    }

    public static <T> T calculate(List<T> list, Calculator calculator) {
        T result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = (T) calculator.calculate(result, list.get(i));
        }
        return result;
    }

    public static <T> int product()
    {
        return calculate(NUMBERS, (a, b) -> {
            return (int) a * (int) b;
        });
    }

    public static <T> int sum()
    {
        return calculate(NUMBERS, (a, b) -> {
            return (int) a + (int) b;
        });
    }

}
