package school.faang.activityanalysis;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private enum ActionType { POST, COMMENT, LIKE, SHARE }

    @Getter
    private static class UserAction {
        private final int id;
        private final String name;
        private final ActionType actionType;
        private final LocalDate actionDate;
        private final String content;

        public UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
            this.id = id;
            this.name = name;
            this.actionType = actionType;
            this.actionDate = actionDate;
            this.content = content;
        }
    }

    static List<UserAction> actions = Arrays.asList(
            new UserAction(1, "Alice", ActionType.POST,
                    LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
            new UserAction(2, "Bob", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
            new UserAction(1, "Alice", ActionType.LIKE,
                    LocalDate.of(2024, 9, 3), ""),
            new UserAction(3, "Charlie", ActionType.SHARE,
                    LocalDate.of(2024, 9, 4), ""),
            new UserAction(4, "Dave", ActionType.POST,
                    LocalDate.of(2024, 9, 5), "#Java is awesome!"),
            new UserAction(2, "Bob", ActionType.LIKE,
                    LocalDate.of(2024, 9, 6), ""),
            new UserAction(3, "Charlie", ActionType.POST,
                    LocalDate.of(2024, 9, 7), "Check out this cool #project"),
            new UserAction(1, "Alice", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"),
            new UserAction(4, "Dave", ActionType.LIKE,
                    LocalDate.of(2024, 9, 9), ""),
            new UserAction(2, "Bob", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 10), "#Java is everywhere."),
            new UserAction(5, "Eve", ActionType.POST,
                    LocalDate.of(2024, 9, 11), "Loving the new #feature release!"),
            new UserAction(3, "Charlie", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 12), "#Java is indeed awesome."),
            new UserAction(5, "Eve", ActionType.LIKE,
                    LocalDate.of(2024, 9, 13), ""),
            new UserAction(4, "Dave", ActionType.SHARE,
                    LocalDate.of(2024, 9, 14), ""),
            new UserAction(2, "Bob", ActionType.POST,
                    LocalDate.of(2024, 9, 15), "Introducing a new #update to the system."),
            new UserAction(1, "Alice", ActionType.SHARE,
                    LocalDate.of(2024, 9, 16), ""),
            new UserAction(5, "Eve", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 17), "#update looks great!"),
            new UserAction(3, "Charlie", ActionType.LIKE,
                    LocalDate.of(2024, 9, 18), ""),
            new UserAction(4, "Dave", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 19), "Really liking the new #feature."),
            new UserAction(2, "Bob", ActionType.SHARE,
                    LocalDate.of(2024, 9, 20), ""),
            new UserAction(1, "Alice", ActionType.POST,
                    LocalDate.of(2024, 9, 21), "Excited for the upcoming #conference!"),
            new UserAction(3, "Charlie", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 22), "I'll be at the #conference too!"),
            new UserAction(5, "Eve", ActionType.LIKE,
                    LocalDate.of(2024, 9, 23), ""),
            new UserAction(4, "Dave", ActionType.POST,
                    LocalDate.of(2024, 9, 24), "Had a great time at the #conference."),
            new UserAction(2, "Bob", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 25), "#conference was a blast!"),
            new UserAction(1, "Alice", ActionType.LIKE,
                    LocalDate.of(2024, 9, 26), ""),
            new UserAction(3, "Charlie", ActionType.SHARE,
                    LocalDate.of(2024, 9, 27), ""),
            new UserAction(5, "Eve", ActionType.POST,
                    LocalDate.of(2024, 9, 28), "The new #update is rolling out today."),
            new UserAction(4, "Dave", ActionType.LIKE,
                    LocalDate.of(2024, 9, 29), ""),
            new UserAction(1, "Alice", ActionType.COMMENT,
                    LocalDate.of(2024, 9, 30), "Excited to try out the new #update!"),
            new UserAction(2, "Bob", ActionType.SHARE,
                    LocalDate.of(2024, 10, 1), ""),
            new UserAction(3, "Charlie", ActionType.COMMENT,
                    LocalDate.of(2024, 10, 2), "The #update has some great features."),
            new UserAction(5, "Eve", ActionType.LIKE,
                    LocalDate.of(2024, 10, 3), ""),
            new UserAction(4, "Dave", ActionType.SHARE,
                    LocalDate.of(2024, 10, 4), ""),
            new UserAction(1, "Alice", ActionType.POST,
                    LocalDate.of(2024, 10, 5), "Loving the new #update so far."),
            new UserAction(2, "Bob", ActionType.LIKE,
                    LocalDate.of(2024, 10, 6), ""),
            new UserAction(3, "Charlie", ActionType.POST,
                    LocalDate.of(2024, 10, 7), "Here's my review of the new #update."),
            new UserAction(5, "Eve", ActionType.COMMENT,
                    LocalDate.of(2024, 10, 8), "Your #review was helpful!"),
            new UserAction(4, "Dave", ActionType.LIKE,
                    LocalDate.of(2024, 10, 9), ""),
            new UserAction(1, "Alice", ActionType.SHARE,
                    LocalDate.of(2024, 10, 10), ""),
            new UserAction(3, "Charlie", ActionType.COMMENT,
                    LocalDate.of(2024, 10, 11), "Sharing my thoughts on the #update."),
            new UserAction(5, "Eve", ActionType.POST,
                    LocalDate.of(2024, 10, 12), "What a great #feature this update brings!"),
            new UserAction(2, "Bob", ActionType.LIKE,
                    LocalDate.of(2024, 10, 13), ""),
            new UserAction(4, "Dave", ActionType.COMMENT,
                    LocalDate.of(2024, 10, 14), "#feature works really well."),
            new UserAction(1, "Alice", ActionType.POST,
                    LocalDate.of(2024, 10, 15), "The #feature saved me a lot of time."),
            new UserAction(3, "Charlie", ActionType.LIKE,
                    LocalDate.of(2024, 10, 16), ""),
            new UserAction(5, "Eve", ActionType.SHARE,
                    LocalDate.of(2024, 10, 17), ""),
            new UserAction(2, "Bob", ActionType.POST,
                    LocalDate.of(2024, 10, 18), "Can't wait for the next #update."),
            new UserAction(4, "Dave", ActionType.SHARE,
                    LocalDate.of(2024, 10, 19), "")
    );

    public static List<String> topActiveUsers(List<UserAction> actions, int topN) {
        Map<String, Long> usersToActionsCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting())); // Группировка по имени
        return usersToActionsCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())  // Сортировка по количеству действий
                .limit(topN)
                .map(Map.Entry::getKey)  // Получаем имена пользователей
                .toList();  // Сохраняем результат в список
    }

    public static List<String> topHashtags(List<UserAction> actions, int topN) {
        Map<String, Long> wordToCount = actions.stream()
                .filter(action -> (ActionType.POST.equals(action.getActionType())
                        || ActionType.COMMENT.equals(action.getActionType()))
                        && action.getContent() != null)
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return wordToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topN) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentCount = actions.stream()
                .filter(action -> ActionType.COMMENT.equals(action.getActionType()) && action.getActionDate()
                        .isAfter(oneMonthAgo))  // Фильтрация по комментариям и дате
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));  // Группировка по имени
        return userNameToCommentCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())  // Сортировка по количеству комментариев
                .limit(topN)
                .map(Map.Entry::getKey)  // Получаем имена пользователей
                .toList();
    }

    public static Map<ActionType, Double> calculateActionPercentages(List<UserAction> actions) {
        long totalActions = actions.size();  // Общее количество действий
        // Группировка по типу действия
        Map<ActionType, Long> actionTypeToCount = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return actionTypeToCount.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,  // Тип действия (post, comment, like, share)
                        entry -> (entry.getValue() * 100.0) / totalActions  // Вычисление процента
                ));
    }

    public static void main(String[] args) {

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionPercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}