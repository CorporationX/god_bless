package school.faang.lambdas.moderator;

import java.util.List;

public class DumbModerator extends Moderator {

    public DumbModerator() {
        rules = List.of(
                new Rule("Rule 1", "Usage of bad word 1 forbidden", notification -> notification.message().contains("bad word 1")),
                new Rule("Rule 2", "Usage of bad word 2 forbidden", notification -> notification.message().contains("bad word 2")));
    }
}