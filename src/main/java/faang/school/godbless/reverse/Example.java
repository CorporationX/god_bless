package faang.school.godbless.reverse;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class Example {

    public void reverse(List<Integer> integerList) {
        if (integerList != null) {
            int size = integerList.size();
            for (int i = 0; i < size / 2; i++) {
                Integer value = integerList.get(i);
                integerList.set(i, integerList.get(size - 1 - i));
                integerList.set(size - 1 - i, value);
            }
        }
    }
}
