package school.faang.bjs2_70890;

import lombok.extern.slf4j.Slf4j;

import static school.faang.bjs2_70890.TestData.ACTIONS;

@Slf4j
public class Main {
    public static void main(String[] args) {
        UserActionAnalyzer userActionAnalyzer = new UserActionAnalyzer();

        log.info(userActionAnalyzer.getTopActiveUsers(ACTIONS, 3).toString());
    }
}
