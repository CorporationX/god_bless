package school.faang.users_activity;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<String> topUsers = UserActionAnalyzer.getTopTenActiveUsers(SourceData.actions);
        List<String> topHashtag = UserActionAnalyzer.getTopFivePopularHashtags(SourceData.actions);
        List<String> topCommenters = UserActionAnalyzer.getTopThreeCommentersLastMonth(SourceData.actions);
        Map<String, Double> actionTypePercentages = UserActionAnalyzer.getActionTypePercentages(SourceData.actions);

        log.info("Top 10 active users {}", topUsers);
        log.info("Top 5 most popular hashtags {}", topHashtag);
        log.info("Top 3 commenters in last month {}", topCommenters);
        log.info("Percentages of action types {}", actionTypePercentages);
    }
}
