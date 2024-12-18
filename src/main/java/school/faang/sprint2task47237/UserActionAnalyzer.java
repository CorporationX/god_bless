package school.faang.sprint2task47237;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {

        //return actions.stream()
        //                  .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))  // Группировка по имени
        //                  .entrySet().stream()
        //                  .sorted(Map.Entry.<String, Long>comparingByValue().reversed())  // Сортировка по количеству действий
        //                  .limit(10)
        //                  .map(Map.Entry::getKey)  // Получаем имена пользователей
        //                  .collect(Collectors.toList());  // Сохраняем результат в список

        Map<String, Long> collect = actions.stream().collect(
                Collectors.groupingBy(UserAction::getName, Collectors.counting())
        );
//
//        System.out.println(collect);

        return collect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());




//        System.out.println(String);
//        return null;
    }
}
