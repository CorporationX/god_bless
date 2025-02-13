package school.faang.task58236.service;

import java.util.List;

public class ListOperations {
    public int summaChet(List<Integer> numb) {
        int result = 0;
        result = numb.stream()
                .filter((num) -> num % 2 == 0)
                .reduce(0, (sum, current) -> sum + current);
        return result;
    }
}
