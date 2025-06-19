package school.faang.bjs2_81134;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = UserActionAnalyzer.generateUserActionList();
        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        log.info("Топ-10 активных пользователей: {}", top10Users);
        log.info("Топ-5 популярных хэштегов: {}", top5Hashtags);
        log.info("Топ-3 комментаторов за последний месяц: {}", top3Commenters);
        log.info("Процент действий по типам: {}", actionPercentages);
    }
}
