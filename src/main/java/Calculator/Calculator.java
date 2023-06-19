package Calculator;

import java.util.List;

public interface Calculator<T> {
    T calculate(List<Integer> nums);
}
