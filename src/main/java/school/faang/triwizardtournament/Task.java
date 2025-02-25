package school.faang.triwizardtournament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public class Task {
    @NonNull
    private final String name;
    private final int difficulty;
    private final int reward;
}
