package faang.school.godbless;

import java.util.List;

public class CheckAllElements {
    public static boolean allElementsMatchCondition (List<String> list) {
        return list.stream()
                .allMatch(x -> x.matches("[a-zA-Z]+"));
    }
}