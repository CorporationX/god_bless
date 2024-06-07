package faang.school.godbless.reverse;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Example {

    public void reverse(Integer[] integerList) {
        if (integerList != null) {
            int size = integerList.length;
            for (int i = 0; i < size / 2; i++) {
                Integer value = integerList[i];
                integerList[i] = integerList[size - 1 - i];
                integerList[size - 1 - i] = value;
            }
        }
    }
}
