package school.faang.sprint_2.user_analysis_in_sm;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<UserAction> findTopOfActiveUsers(List<UserAction> actions, int top) {
        return actions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.get().compareTo(a.getValue()))
                .limit(top)
                .toList();
    }
}
