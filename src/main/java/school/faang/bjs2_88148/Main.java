package school.faang.bjs2_88148;

import java.util.List;

public class Main {
    private static final int COUNT_ACTIVE_USERS = 10;
    private static final int COUNT_POPULAR_TAGS = 5;
    private static final int COUNT_USERS_COMMENT = 3;

    public static void main(String[] args) {
        List<UserAction> actions = UserActionFactory.createDefaultActions();

        System.out.printf("Топ-10 активных пользователей: %s\n",
               UserActionAnalyzer.topActiveUsers(actions, COUNT_ACTIVE_USERS));

        System.out.printf("Топ-5 популярных хэштегов: %s\n",
                UserActionAnalyzer.topPopularHashtags(actions, COUNT_POPULAR_TAGS));

        System.out.printf("Топ-3 пользователей, с наибольшим количеством комментариев в последнем месяце: %s\n",
                UserActionAnalyzer.topCommentersLastMonth(actions, COUNT_USERS_COMMENT));

        System.out.printf("Процент действий по типам: %s\n",
                UserActionAnalyzer.actionTypePercentages(actions));
    }
}
