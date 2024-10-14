package school.faang.BJS2_33918;

import java.util.List;

public class DataCenter {
    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        T result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static <T extends Number> T sum(List<T> nums) {
        return calculate(nums, DataCenter::add);
    }

    public static <T extends Number> T product(List<T> nums) {
        return calculate(nums, DataCenter::multiply);
    }

    private static <T extends Number> T add(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() + b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() + b.longValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }

    private static <T extends Number> T multiply(T a, T b) {
        if (a instanceof Integer) {
            return (T) Integer.valueOf(a.intValue() * b.intValue());
        } else if (a instanceof Double) {
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        } else if (a instanceof Long) {
            return (T) Long.valueOf(a.longValue() * b.longValue());
        } else {
            throw new IllegalArgumentException("Unsupported number type");
        }
    }
}