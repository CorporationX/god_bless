package school.faang.task_47168;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = UserActionGenerator.generateRandomActions(100);

        UserActionAnalyzer analyzer = new UserActionAnalyzer();

        System.out.println("Топ активных пользователей:");
        analyzer.getTopActiveUsers(actions, 3).forEach(System.out::println);

        System.out.println("\nТоп популярных хэштегов:");
        analyzer.getTopHashtags(actions, 5).forEach(System.out::println);

        System.out.println("\nДействия за последний месяц:");
        analyzer.getActionsWithinLastMonth(actions).forEach(System.out::println);
    }
}