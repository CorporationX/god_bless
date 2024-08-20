package faang.school.godbless.Calculator;

import java.util.List;

public class Math {
    public static <T extends Number> T product(List<T> nums) {
        return calculate(nums, (a, b) -> {
            if (a instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() * b.intValue());
            } else if (a instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
            } else if (a instanceof Float) {
                return (T) Float.valueOf(a.floatValue() * b.floatValue());
            } else if (a instanceof Long) {
                return (T) Long.valueOf(a.longValue() * b.longValue());
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    public static <T extends Number> T sum(List<T> nums) {
        return calculate(nums, (a, b) -> {
            if (a instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() + b.intValue());
            } else if (a instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
            } else if (a instanceof Float) {
                return (T) Float.valueOf(a.floatValue() + b.floatValue());
            } else if (a instanceof Long) {
                return (T) Long.valueOf(a.longValue() + b.longValue());
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    public static <T extends Number> T dif(List<T> nums) {
        return calculate(nums, (a, b) -> {
            if (a instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() - b.intValue());
            } else if (a instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
            } else if (a instanceof Float) {
                return (T) Float.valueOf(a.floatValue() - b.floatValue());
            } else if (a instanceof Long) {
                return (T) Long.valueOf(a.longValue() - b.longValue());
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    public static <T extends Number> T div(List<T> nums) {
        return calculate(nums, (a, b) -> {
            if (a instanceof Integer) {
                return (T) Integer.valueOf(a.intValue() / b.intValue());
            } else if (a instanceof Double) {
                return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
            } else if (a instanceof Float) {
                return (T) Float.valueOf(a.floatValue() / b.floatValue());
            } else if (a instanceof Long) {
                return (T) Long.valueOf(a.longValue() / b.longValue());
            } else {
                throw new IllegalArgumentException("Unsupported type");
            }
        });
    }

    private static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("nums is null or empty");
        }

        T value = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            value = calculator.calculate(value, nums.get(i));
        }

        return value;
    }
}
