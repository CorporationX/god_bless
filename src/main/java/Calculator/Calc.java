package Calculator;

import java.util.List;

public interface Calc<T> {
    T calculate(List<Integer> nums);
}
