package faang.school.godbless.calculator;

import java.util.List;

public class Operations {
    public static Number calculate (List<Number> nums, Calculator<Number> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        Number result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }

        return result;
    }

    public static Number multiply (List<Number> nums) {
        return calculate(nums, (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return a.intValue() * b.intValue();
            } else if (a instanceof Long && b instanceof Long) {
                return a.longValue() * b.longValue();
            } else if (a instanceof Double && b instanceof Double) {
                return a.doubleValue() * b.doubleValue();
            } else if (a instanceof Float && b instanceof Float) {
                return a.floatValue() * b.floatValue();
            } else {
                throw new IllegalArgumentException("All values should be of the same type");
            }
        });
    }

    public static Number sum (List<Number> nums) {
        return calculate(nums, (a, b) -> {
            if (a instanceof Integer && b instanceof Integer) {
                return a.intValue() + b.intValue();
            } else if (a instanceof Long && b instanceof Long) {
                return a.longValue() + b.longValue();
            } else if (a instanceof Double && b instanceof Double) {
                return a.doubleValue() + b.doubleValue();
            } else if (a instanceof Float && b instanceof Float) {
                return a.floatValue() + b.floatValue();
            } else {
                throw new IllegalArgumentException("All values should be of the same type");
            }
        });
    }
}
