package school.faang.collections_stream_optional_2_2.bjs2_70890;

import lombok.extern.slf4j.Slf4j;

import static school.faang.collections_stream_optional_2_2.bjs2_70890.TestData.ACTIONS;

@Slf4j
public class Main {
    public static void main(String[] args) {
        UserActionAnalyzer userActionAnalyzer = new UserActionAnalyzer();

        log.info(userActionAnalyzer.getTopActiveUsers(ACTIONS, 3).toString());
        log.info(userActionAnalyzer.getTopDiscussedTopics(ACTIONS, 2).toString());
        log.info(userActionAnalyzer.getTopCommentatorsForMonth(ACTIONS, 3).toString());
        log.info(userActionAnalyzer.calculateActionTypePercentages(ACTIONS).toString());
    }
}
