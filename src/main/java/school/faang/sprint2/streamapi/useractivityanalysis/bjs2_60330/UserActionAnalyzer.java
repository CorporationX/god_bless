package school.faang.sprint2.streamapi.useractivityanalysis.bjs2_60330;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<User> findTopActiveUsers(List<UserAction> userActions, long limit) {
        Map<Long, Long> countMap = userActions.stream()
                .collect(Collectors.groupingBy(s -> s.getId(),Collectors.counting()));
        countMap.entrySet().stream().sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(limit).map(Map.Entry::getKey).collect(Collectors.toList());
        return null;

    }
}
