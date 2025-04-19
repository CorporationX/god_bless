package school.faang.analysisuser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<UserAction> toActiveUser (List<UserAction> users, int top) {
        Map<Integer, List<UserAction>> groupById = users.stream().peek(System.out::println)
                .collect(Collectors.groupingBy(UserAction::getId));

//        groupById.entrySet().stream()
//                .sorted()
        return new ArrayList<>();

    }

}
