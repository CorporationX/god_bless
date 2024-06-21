package faang.school.godbless.Task_Activity_Analysis;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Application {

    public static List<Integer> findTheMostActiveUsers(List<UserAction> userActions) {
        Map<Integer, Integer> namesAndActions = new HashMap<>();
        userActions.forEach(x -> {
            int numberOfActions = (int) userActions.stream().filter(y -> y.getId() == x.getId()).count();
            namesAndActions.put(x.getId(), numberOfActions);
        });
        return namesAndActions.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(10)
                .map(Map.Entry::getKey).toList();
    }

}
