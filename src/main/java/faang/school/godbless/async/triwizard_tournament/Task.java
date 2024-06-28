package faang.school.godbless.async.triwizard_tournament;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Task {
    private String name;
    private int difficulty;
    private int reward;
}
