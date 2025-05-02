package school.faang.sprint_2.user_analysis_in_sm;

import java.util.Map;

import static school.faang.sprint_2.user_analysis_in_sm.Data.actions;

public class Main {
    public static void main(String[] args) {
        Data.loadData();
        Map<String, Integer> top10Users = UserActionAnalyzer.findTopOfActiveUsers(actions, 10);
        top10Users.forEach((id, amountOfActions) ->
                System.out.println(id + " -> " + amountOfActions));

        Map<String, Integer> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        top5Hashtags.forEach((hashtag, amountOfActions) ->
                System.out.println(hashtag + " -> " + amountOfActions));

        Map<Integer, Integer> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);

        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionTypePercentages(actions);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
