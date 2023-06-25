package faang.school.godbless;

import java.util.List;

public class ResourceAnalytics {
    public <T> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalAccessException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalAccessException("List cannot be empty or null");
        }
        T result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
}
