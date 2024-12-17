package school.faang.users_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> topUsers = UserActionAnalyzer.topTenActiveUsers(SourceData.actions);
        System.out.println(topUsers);
        List<String> topHashtag = UserActionAnalyzer.topFivePopularHashtags(SourceData.actions);
        System.out.println(topHashtag);
    }
}
