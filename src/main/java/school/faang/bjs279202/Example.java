package school.faang.bjs279202;

import java.util.List;

public class Example {
    public List<Integer> reverse(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            // меняем местами list[i] и list[j]
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);

            i++;
            j--;
        }
        return list;
    }
}
